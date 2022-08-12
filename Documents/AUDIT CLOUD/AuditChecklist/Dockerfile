FROM openjdk:11
EXPOSE 9100
ADD target/AuditChecklist.jar audit-checklist.jar
ENTRYPOINT ["java", "-jar", "/audit-checklist.jar"]