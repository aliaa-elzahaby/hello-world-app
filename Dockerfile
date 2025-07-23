# Use an official OpenJDK runtime as a parent image
FROM openjdk:17-jdk-alpine

# Set working directory inside the container
WORKDIR /app

# Copy the jar file built by Maven to the container
COPY target/hello-world-app-1.0-SNAPSHOT.jar app.jar

# Run the jar file
ENTRYPOINT ["java", "-jar", "app.jar"]
