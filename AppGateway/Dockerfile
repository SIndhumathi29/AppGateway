FROM openjdk:11
ADD target/gateway.jar gateway.jar
EXPOSE 8087
ENTRYPOINT ["java","-jar","gateway.jar"]