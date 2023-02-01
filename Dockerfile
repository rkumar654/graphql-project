#Stage 1
FROM adoptopenjdk/openjdk11:alpine-jre

RUN echo 'Building flow started'
#RUN mvn clean install
WORKDIR /opt/app
ARG JAR_FILE=target/graphql-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} app.jar
CMD ["java","-jar","app.jar"]

EXPOSE  8080