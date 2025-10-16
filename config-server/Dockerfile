FROM eclipse-temurin:21-jdk-jammy
WORKDIR /app
COPY build/libs/app.jar .
EXPOSE 8888
ENTRYPOINT ["java", "-jar", "app.jar"]
