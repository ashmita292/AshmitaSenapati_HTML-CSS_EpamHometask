FROM openjdk:11
EXPOSE 9400
COPY ./target/*.jar audit-authentication.jar
ENTRYPOINT ["java", "-jar", "/audit-authentication.jar"]