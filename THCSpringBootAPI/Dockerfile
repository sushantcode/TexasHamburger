FROM openjdk:11
ARG JAR_FILE=target/THC-Spring-Boot-API.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]