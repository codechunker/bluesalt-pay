FROM openjdk:11
ADD target/*.jar billing-service-worker
EXPOSE 9098
ENTRYPOINT ["java","-jar","billing-worker-service"]