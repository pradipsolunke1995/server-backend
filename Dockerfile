FROM openjdk:8
ADD target/db-server.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]