FROM openjdk:17-jdk-slim-buster
COPY target/agentes-api-**.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]