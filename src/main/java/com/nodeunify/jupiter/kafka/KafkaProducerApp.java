package com.nodeunify.jupiter.kafka;

import java.util.Properties;

import com.nodeunify.jupiter.datastream.v1.Quote;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;

public class KafkaProducerApp {
    public static void main(String[] args) {
        Properties props = new Properties();
        props.put("bootstrap.servers", "kafka:9092");
        props.put("acks", "all");
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.ByteArraySerializer");
        Producer<String, byte[]> producer = new KafkaProducer<>(props);

        // @formatter:off
        Quote quote = Quote
            .newBuilder()
            .setCode("600200")
            .setLastPx(1343)
            .build();
        // @formatter:on

        producer.send(new ProducerRecord<String, byte[]>("test.in", "600200", quote.toByteArray()));
        producer.close();
    }
}
