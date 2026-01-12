# Paso 1: Construcción (Usamos Java 21)
FROM maven:3.9.6-eclipse-temurin-21 AS build
COPY . .
RUN mvn clean package -DskipTests

# Paso 2: Ejecución
FROM eclipse-temurin:21-jdk
COPY --from=build /target/*.jar app.jar
EXPOSE 8087
ENTRYPOINT ["java", "-jar", "/app.jar"]