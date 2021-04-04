FROM openjdk:11
VOLUME /tmp
ADD target/addresschallenge-api-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]