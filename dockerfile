FROM eclipse-temurin:21-jdk

WORKDIR /app

COPY target/vital-signs-producer-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8087

ENTRYPOINT [ "java", "-jar", "app.jar" ]