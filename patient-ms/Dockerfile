FROM openjdk:11

WORKDIR /health

COPY target/patient-ms.jar /health/patient-ms.jar

EXPOSE 8081

ENTRYPOINT ["java","-jar", "/health/patient-ms.jar"]