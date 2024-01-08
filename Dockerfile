#1st Stage
FROM maven:3.6.3-openjdk-17-slim as build-stage
WORKDIR /app
COPY pom.xml /app/
RUN mvn dependency:go-offline -B
COPY src /app/src
RUN mvn package -DskipTests

#2nd Stage to add change
FROM openjdk:17-slim
WORKDIR /app
COPY --from=build-stage /app/target/Bank-System-0.0.1-SNAPSHOT.jar /app/bank-server
EXPOSE 8081
CMD ["java", "-jar", "Bank-System-0.0.1-SNAPSHOT.jar"]