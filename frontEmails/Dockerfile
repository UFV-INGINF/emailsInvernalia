FROM amazoncorretto:17-alpine

WORKDIR /app

RUN apk --no-cache add curl
COPY target/*.jar app.jar

EXPOSE 8080

CMD ["java", "-jar", "app.jar"]