FROM maven:3.8-openjdk-18-slim
RUN mvn clean package && \
	java -jar /target/Greeter.jar
