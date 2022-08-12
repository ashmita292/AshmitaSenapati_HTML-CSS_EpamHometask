FROM openjdk:11
EXPOSE 9400
ADD target/AuditAuthentication-0.0.1-SNAPSHOT.jar audit-authentication.jar
ENTRYPOINT ["java", "-jar", "/audit-authentication.jar"]