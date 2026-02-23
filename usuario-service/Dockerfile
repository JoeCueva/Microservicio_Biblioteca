FROM maven:3.9.9-eclipse-temurin-17 AS builder

WORKDIR /workspace

# 1. biblioteca-Entity
COPY biblioteca-Entity/pom.xml ./biblioteca-Entity/pom.xml
COPY biblioteca-Entity/src ./biblioteca-Entity/src
RUN mvn -f biblioteca-Entity/pom.xml clean install -DskipTests

# 2. usuario-service
COPY usuario-service/pom.xml ./usuario-service/pom.xml
COPY usuario-service/src ./usuario-service/src
RUN mvn -f usuario-service/pom.xml clean package -DskipTests

FROM eclipse-temurin:17-jre-alpine
WORKDIR /app
COPY --from=builder /workspace/usuario-service/target/*.jar usuario-service.jar
EXPOSE 1003
ENTRYPOINT ["java", "-jar", "usuario-service.jar"]
