FROM gradle:8.0-jdk19 AS builder
COPY . /app
WORKDIR /app
RUN gradle shadowJar --no-daemon

FROM eclipse-temurin:18
COPY --from=builder /app/build/libs /app
WORKDIR /app
RUN ["java", "-jar", "Greeter-shadow.jar"]
