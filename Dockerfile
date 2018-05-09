FROM openjdk:8
COPY target/movie-0.0.1-SNAPSHOT.jar mowie-app.jar
ENTRYPOINT ["java","-jar","mowie-app.jar"]