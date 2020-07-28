FROM openjdk:11.0
VOLUME /tmp
EXPOSE 8080
ADD ./target/saludespe-servicio-trabajo-social-1.0.0.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]