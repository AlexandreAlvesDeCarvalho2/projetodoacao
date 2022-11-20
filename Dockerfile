FROM adoptopenjdk:11-jre-hotspot

ARG JAR_FILE=target/projetodoacao-0.0.1-SNAPSHOT.jar

WORKDIR /opt/app

COPY ${JAR_FILE} app.jar

ENTRYPOINT [ "java", "-jar", "app.jar" ]

EXPOSE 80

# criar package = mvn clean install -DskipTests=true
# build image 
# rodar em ambiente local -> docker run -d -p 80:80 -t alexandre/springboot:latest

