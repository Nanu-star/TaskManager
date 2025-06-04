# Use Gradle to build the project
FROM gradle:7.6-jdk11 AS build
WORKDIR /home/app
COPY --chown=gradle:gradle . /home/app
RUN gradle bootJar --no-daemon

# Use a lightweight JRE for running the app
FROM openjdk:11-jre-slim
COPY --from=build /home/app/build/libs/*.jar /app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app.jar"]
