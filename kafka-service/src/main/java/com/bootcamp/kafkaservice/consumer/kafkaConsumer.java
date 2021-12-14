package com.bootcamp.kafkaservice.consumer;

import com.bootcamp.kafkaservice.model.User;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class kafkaConsumer {
    Logger logger = LoggerFactory.getLogger(KafkaConsumer.class);
    @KafkaListener(topics = "TOPIC-DEMO" , groupId = "group_id")
    public void consume(String message) {
        logger.info("Consuming Message {}", message);
    }
}
