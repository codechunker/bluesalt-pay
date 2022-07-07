FROM openjdk:11
EXPOSE 8081
ADD target/*.jar customer-service
ENTRYPOINT ["java","-jar","customer-service"]