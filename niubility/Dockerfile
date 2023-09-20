FROM amazoncorretto:17

EXPOSE 8080

COPY target/niubility-1.0-SNAPSHOT.jar /opt/demo.jar

WOKDIR /opt/

ENTRYPOINT exec java -jar /opt/demo.jar
