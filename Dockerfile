#FROM frolvlad/alpine-oraclejdk8:slim
#FROM carsharing/alpine-oraclejdk8-bash
#VOLUME /tmp
#ADD /target/demo-0.0.1-SNAPSHOT.jar app.jar
#ENTRYPOINT ["java","-jar","/app.jar"]

FROM java:8
VOLUME /tmp
ADD demo-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8082
ENTRYPOINT [ "java", "-jar", "/app.jar" ]