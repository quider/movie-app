FROM openjdk:8
COPY ${JAR_FILE} mowie-app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]