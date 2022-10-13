FROM openjdk:20-jdk-slim

COPY "target/jv_springboot_intellij-0.0.1-SNAPSHOT.jar" "app.jar"

EXPOSE 80

ENTRYPOINT ["java", "-jar", "app.jar"]