FROM hub.c.163.com/library/java:8-alpine

ADD target/*.jar app.jar

EXPOSE 861

ENTRYPOINT ["java","-jar","/app.jar"]