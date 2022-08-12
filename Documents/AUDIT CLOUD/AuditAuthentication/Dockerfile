FROM openjdk:11
EXPOSE 9400
ADD ./target/*.jar audit-authentication.jar
ENTRYPOINT ["java", "-jar", "/audit-authentication.jar"]