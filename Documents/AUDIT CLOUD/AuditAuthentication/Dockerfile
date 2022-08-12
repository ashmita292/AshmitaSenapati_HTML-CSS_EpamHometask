#
# Build stage
#
FROM maven:3.8.5-jdk-11-slim AS build
WORKDIR /home/app
ARG path1= "/Documents/AUDIT CLOUD/AuditAuthentication/src"
ARG path2= "/Documents/AUDIT CLOUD/AuditAuthentication/pom.xml"
COPY ${path1} src
COPY ${path2} pom.xml
RUN mvn clean package

#
# Package stage
#
FROM openjdk:11
COPY --from=build /home/app/target/AuditAuthentication-0.0.1-SNAPSHOT.jar audit-authentication.jar
EXPOSE 9400
ENTRYPOINT ["java","-jar","audit-authentication.jar"]
