FROM openjdk:11-jdk-alpine
EXPOSE 9400
ADD target/*.jar app.jar
ENTRYPOINT [ "sh", "-c", "java -Djava.security.egd=file:/dev/./urandom -jar /app.jar" ]

