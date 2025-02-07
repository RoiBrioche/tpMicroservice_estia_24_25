FROM openjdk:17-oracle
VOLUME /tmp
ADD build/libs/*.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]