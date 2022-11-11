FROM openjdk:20-jdk-slim

COPY "target/jv-0.2.0.jar" "app.jar"
COPY "recursos/" "recursos/"
#ADD myDb myDb

ENTRYPOINT ["java", "-jar", "app.jar"]

