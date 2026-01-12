# Paso 1: Construcción
FROM maven:3.8.5-openjdk-17 AS build
COPY . .
RUN mvn clean package -DskipTests

# Paso 2: Ejecución (Cambiamos la imagen base a una más común)
FROM eclipse-temurin:17-jdk
COPY --from=build /target/*.jar app.jar
EXPOSE 8087
ENTRYPOINT ["java", "-jar", "/app.jar"]