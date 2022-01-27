FROM maven:3.8-openjdk-17-slim AS build-env
COPY src /usr/src/app/src
COPY pom.xml /usr/src/app
WORKDIR /usr/src/app
RUN mvn -f pom.xml clean package
RUN jdeps \
    --ignore-missing-deps \
    -q \
    --multi-release 17 \
    --print-module-deps \
    target/greeter-0.0.1-SNAPSHOT-jar-with-dependencies.jar > target/jre-deps.info
RUN jlink --verbose \
    --compress 2 \
    --strip-java-debug-attributes \
    --no-header-files \
    --no-man-pages \
    --output target/jre \
    --add-modules $(cat jre-deps.info)

FROM gcr.io/distroless/base-debian11
COPY --from=build-env /usr/src/app/target/greeter-0.0.1-SNAPSHOT-jar-with-dependencies.jar /app/greeter.jar
COPY --from=build-env /usr/src/app/target/jre /app/jre
WORKDIR /app
RUN ["jre/bin/java", "-jar", "greeter.jar"]
