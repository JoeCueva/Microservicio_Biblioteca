FROM maven:3.9.9-eclipse-temurin-22 AS builder

# Carpeta de trabajo
WORKDIR /workspace

# Copiamos las fuentes de las aplicaciones
COPY src ./src
COPY pom.xml ./pom.xml

# Compilamos el proyecto (generará el .jar)
RUN mvn clean install -DskipTests


# ========================
# STAGE 2: Imagen final
# ========================
FROM eclipse-temurin:22-jre-alpine

ENV JAVA_OPTS="-XX:+UseContainerSupport -XX:MaxRAMPercentage=70 -XX:InitialRAMPercentage=40 -XX:+UseG1GC"

# Carpeta de trabajo
WORKDIR /app
COPY --from=builder /workspace/target/*.jar api-gateway.jar

EXPOSE 8081

# Comando de ejecución
ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -jar api-gateway.jar"]