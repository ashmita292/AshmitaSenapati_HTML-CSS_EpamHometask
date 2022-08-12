FROM openjdk:11
EXPOSE 9400
ADD Documents/"AUDIT CLOUD"/AuditAuthentication/target/AuditAuthentication-0.0.1-SNAPSHOT.jar audit-authentication.jar
ENTRYPOINT ["java", "-jar", "/audit-authentication.jar"]