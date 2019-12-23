FROM openjdk:latest

RUN mkdir -p /opt/kpatil/geotracker

ADD target/geotracker-1.0.0.jar /opt/kpatil/geotracker/

EXPOSE 8080

CMD ["java", "-jar", "/opt/kpatil/geotracker/geotracker-1.0.0.jar"]




