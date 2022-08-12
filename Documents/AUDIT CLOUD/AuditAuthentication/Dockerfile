FROM openjdk:11
EXPOSE 9400
ADD Documents/"AUDIT CLOUD"/AuditAuthentication/target/AuditAuthentication-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT [ "sh", "-c", "java -Djava.security.egd=file:/dev/./urandom -jar /app.jar" ]

