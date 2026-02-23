FROM maven:3.9.0-eclipse-temurin-17 AS builder

WORKDIR /workspace

COPY src ./src
COPY pom.xml ./pom.xml

RUN mvn clean install -DskipTests

FROM eclipse-temurin:17-jre-alpine

WORKDIR /app

COPY --from=builder /workspace/target/*.jar eureka-server.jar

EXPOSE 8761

ENTRYPOINT [ "sh", "-c", "java -jar eureka-server.jar" ]