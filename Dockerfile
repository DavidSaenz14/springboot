# Imagen base con Java 17 JRE
FROM eclipse-temurin:17-jre
WORKDIR /app

# Copiar el JAR ya compilado
COPY target/springboot-0.0.1-SNAPSHOT.jar app.jar

# Puerto que Render usará
EXPOSE 8080
ENV PORT=8080

# Ejecutar la app
ENTRYPOINT ["java", "-jar", "app.jar"]
