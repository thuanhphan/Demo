FROM openjdk:11
ADD target/spring-web-example-8-0.0.1-SNAPSHOT.jar spring-web-example-8-0.0.1-SNAPSHOT.jar
EXPOSE 8081
ENTRYPOINT ["java", "-jar", "spring-web-example-8-0.0.1-SNAPSHOT.jar", "/docker-entrypoint-initdb.d/ScriptCreateDB.sql"]
### k8s can not mount so need to copy/add file to dockerfile
#COPY ./ScriptCreateDB.sql /docker-entrypoint-initdb.d/ScriptCreateDB.sql