FROM openjdk:11
EXPOSE 9400
ARG path="Documents/AUDIT CLOUD/AuditAuthentication/target/AuditAuthentication-0.0.1-SNAPSHOT.jar"
ADD ${path} app.jar
ENTRYPOINT [ "sh", "-c", "java -Djava.security.egd=file:/dev/./urandom -jar /app.jar" ]

