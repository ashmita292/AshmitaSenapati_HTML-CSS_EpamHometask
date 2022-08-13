FROM openjdk:11
EXPOSE 9100
ARG path="Documents/AUDIT CLOUD/AuditChecklist/target/Audit-Checklist-0.0.1-SNAPSHOT.jar"
ADD ${path} app.jar
ENTRYPOINT [ "sh", "-c", "java -Djava.security.egd=file:/dev/./urandom -jar /app.jar" ]