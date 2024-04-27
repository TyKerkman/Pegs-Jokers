FROM openjdk:17-jdk-alpine
LABEL authors="Tage"
WORKDIR /app
COPY build/libs/PegsAndJokers-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]