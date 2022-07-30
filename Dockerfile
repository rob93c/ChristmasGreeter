FROM maven:3.8-openjdk-18-slim
COPY src /usr/src/app/src
COPY pom.xml /usr/src/app
ENV CODACY_PROJECT_TOKEN=b380d16b875b4a7da2f0d9ffb95def1e
RUN mvn -f /usr/src/app/pom.xml clean package && \
	java -jar /usr/src/app/target/Greeter.jar && \
	bash <$(curl -Ls https://coverage.codacy.com/get.sh) report -r /usr/src/app/target/site/jacoco/jacoco.xml
