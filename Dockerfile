# Paso 1: Construir la aplicación usando Maven
FROM maven:3.8.4-openjdk-17-slim AS build
COPY . .
RUN mvn clean package -DskipTests

# Paso 2: Ejecutar la aplicación con Java 17
FROM openjdk:17-jdk-slim
COPY --from=build /target/*.jar app.jar
EXPOSE 8087
ENTRYPOINT ["java", "-jar", "/app.jar"]