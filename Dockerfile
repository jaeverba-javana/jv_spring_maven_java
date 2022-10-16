FROM openjdk:20-jdk-slim

COPY "target/jv-0.0.1-SNAPSHOT.jar" "app.jar"
COPY "recursos/" "recursos/"
#ADD myDb myDb

ENTRYPOINT ["java", "-jar", "app.jar"]

