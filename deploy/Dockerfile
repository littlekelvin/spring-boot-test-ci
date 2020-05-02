FROM openjdk:8-jdk-alpine

ENV APP_HOME=/usr/app

COPY ./spring-boot-test-ci.jar ${APP_HOME}/app.jar

RUN chmod 777 ${APP_HOME}/app.jar

VOLUME /usr/app

EXPOSE 8001/tcp

ENTRYPOINT ["java", "-jar", "app.jar"]