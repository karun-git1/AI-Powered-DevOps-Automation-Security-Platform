
FROM eclipse-temurin:17-jre-alpine
WORKDIR /app
COPY target/security-service.jar app.jar
EXPOSE 8082
ENTRYPOINT ["java", "-jar", "app.jar"]