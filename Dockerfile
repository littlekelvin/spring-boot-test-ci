FROM openjdk:8-jdk-alpine

ENV APP_HOME=/usr/app

COPY ./target/spring-boot-test-ci.jar ${APP_HOME}/app.jar

RUN chmod 777 ${APP_HOME}/app.jar

EXPOSE 7090/tcp
