FROM openjdk:21-jdk-slim

LABEL authors="wjoansah"

RUN groupadd --system app && useradd --system app -g app
USER app

EXPOSE 8088

COPY target/*.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]
