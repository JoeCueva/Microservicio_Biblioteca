FROM maven:3.9.9-eclipse-temurin-17 AS builder

WORKDIR /workspace

# 1. biblioteca-Entity
COPY biblioteca-Entity/pom.xml ./biblioteca-Entity/pom.xml
COPY biblioteca-Entity/src ./biblioteca-Entity/src
RUN mvn -f biblioteca-Entity/pom.xml clean install -DskipTests

# 2. usuario-service (Libros lo necesita como dependencia)
COPY usuario-service/pom.xml ./usuario-service/pom.xml
COPY usuario-service/src ./usuario-service/src
RUN mvn -f usuario-service/pom.xml clean install -DskipTests

# 3. Libros
COPY Libros/pom.xml ./Libros/pom.xml
COPY Libros/src ./Libros/src
RUN mvn -f Libros/pom.xml clean package -DskipTests

FROM eclipse-temurin:17-jre-alpine
WORKDIR /app
COPY --from=builder /workspace/Libros/target/*.jar libros.jar
EXPOSE 1001
ENTRYPOINT ["java", "-jar", "libros.jar"]
