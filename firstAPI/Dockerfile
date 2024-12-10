FROM amazoncorretto:17-alpine


RUN mkdir -p /app/exit
RUN mkdir /exit
WORKDIR /app

COPY target/*.jar app.jar
COPY email.json email.json
COPY ListEmails.json ListEmails.json

CMD ["java", "-jar", "app.jar"]