FROM maven:3.8-openjdk-17-slim AS build-env
COPY src /usr/src/app/src  
COPY pom.xml /usr/src/app  
RUN mvn -f /usr/src/app/pom.xml clean package

FROM gcr.io/distroless/java17-debian11
COPY --from=build-env /usr/src/app/target/greeter-0.0.1-SNAPSHOT-jar-with-dependencies.jar /usr/app/greeter.jar
RUN ["java","-jar","/usr/app/greeter.jar"]