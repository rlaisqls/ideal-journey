FROM openjdk:17-jre-slim

COPY ./build/libs/*.jar app.jar

ENV TZ=Asia/Seoul
EXPOSE 8080

ENTRYPOINT ["java","-jar","/app.jar"]
