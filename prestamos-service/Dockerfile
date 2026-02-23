FROM maven:3.9.9-eclipse-temurin-17 AS builder

WORKDIR /workspace

COPY biblioteca-Entity/pom.xml ./biblioteca-Entity/pom.xml
COPY biblioteca-Entity/src ./biblioteca-Entity/src
RUN mvn -f biblioteca-Entity/pom.xml clean install -DskipTests

COPY usuario-service/pom.xml ./usuario-service/pom.xml
COPY usuario-service/src ./usuario-service/src
RUN mvn -f usuario-service/pom.xml clean install -DskipTests

COPY Libros/pom.xml ./Libros/pom.xml
COPY Libros/src ./Libros/src
RUN mvn -f Libros/pom.xml clean install -DskipTests

COPY prestamos-service/pom.xml ./prestamos-service/pom.xml
COPY prestamos-service/src ./prestamos-service/src
RUN mvn -f prestamos-service/pom.xml clean package -DskipTests

FROM eclipse-temurin:17-jre-alpine
WORKDIR /app
COPY --from=builder /workspace/prestamos-service/target/*.jar prestamos-service.jar
EXPOSE 1002
ENTRYPOINT ["java", "-jar", "prestamos-service.jar"]
