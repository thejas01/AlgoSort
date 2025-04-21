# Build stage
FROM maven:3.9.9-eclipse-temurin-17-alpine as build

WORKDIR /app

# Copy pom.xml and download dependencies
COPY pom.xml .
RUN mvn dependency:go-offline

# Copy source code
COPY src ./src

# Build the application
RUN mvn package -DskipTests

# Production stage
FROM eclipse-temurin:17-jre-alpine

WORKDIR /app

# Copy the built JAR file
COPY --from=build /app/target/*.jar app.jar

EXPOSE 8082

CMD ["java", "-jar", "app.jar"]