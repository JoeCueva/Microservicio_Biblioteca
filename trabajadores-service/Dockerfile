FROM maven:3.9.9-eclipse-temurin-17 AS builder

WORKDIR /workspace

COPY biblioteca-Entity/pom.xml ./biblioteca-Entity/pom.xml
COPY biblioteca-Entity/src ./biblioteca-Entity/src
RUN mvn -f biblioteca-Entity/pom.xml clean install -DskipTests

COPY trabajadores-service/pom.xml ./trabajadores-service/pom.xml
COPY trabajadores-service/src ./trabajadores-service/src
RUN mvn -f trabajadores-service/pom.xml clean package -DskipTests

FROM eclipse-temurin:17-jre-alpine
WORKDIR /app
COPY --from=builder /workspace/trabajadores-service/target/*.jar trabajadores-service.jar
EXPOSE 1004
ENTRYPOINT ["java", "-jar", "trabajadores-service.jar"]
