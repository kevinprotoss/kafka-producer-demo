FROM openjdk:8u222-slim

RUN mkdir -p /app
COPY build/distributions/kafka-consumer-master-SNAPSHOT /app
WORKDIR /app

CMD [ "bin/kafka-consumer" ]
