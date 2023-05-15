FROM openjdk:11
ADD target/spring-web-example-8-0.0.1-SNAPSHOT.jar spring-web-example-8-0.0.1-SNAPSHOT.jar
EXPOSE 8081
ENTRYPOINT ["java", "-jar", "spring-web-example-8-0.0.1-SNAPSHOT.jar"]