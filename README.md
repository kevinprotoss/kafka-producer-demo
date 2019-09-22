# Kafka Producer Demo

### How to use

```
gradle clean build
unzip build/distributions/kafka-consumer-master-SNAPSHOT
docker build --no-cache --rm=true -t JupiterFund/kafka-producer-demo .
docker run --name kafka-producer-demo --network docker-spark_default -d JupiterFund/kafka-producer-demo
```
