FROM openjdk:11

WORKDIR /health

COPY target/appointment-ms.jar /health/appointment-ms.jar

EXPOSE 8082

ENTRYPOINT ["java","-jar", "/health/appointment-ms.jar"]