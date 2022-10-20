FROM gradle:7.5.1-jdk18 AS builder
COPY . /app
WORKDIR /app
RUN gradle shadowJar --no-daemon

FROM eclipse-temurin:19
COPY --from=builder /app/build/libs /app
WORKDIR /app
RUN ["java", "-jar", "Greeter-shadow.jar"]
