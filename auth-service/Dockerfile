FROM eclipse-temurin:21-jdk-jammy
WORKDIR /app
COPY build/libs/app.jar .
EXPOSE 9091 
ENTRYPOINT ["java", "-jar", "app.jar"]
