package com.bootcamp.kafkaservice.producer;

import com.bootcamp.kafkaservice.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class kafkaProducerJson {
    private static final Logger LOGGER = LoggerFactory.getLogger(kafkaProducer.class);
    private final KafkaTemplate<String, User> kafkaTemplate;
    public kafkaProducerJson(@Qualifier("kafkaJsonTemplate") KafkaTemplate<String, User> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }
    public void sendMessage(User user) {
        LOGGER.info("Producing message {}", user);
        this.kafkaTemplate.send("TOPIC-DEMO", user);
    }
}
