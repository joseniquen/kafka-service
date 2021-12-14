package com.bootcamp.kafkaservice.producer;

import com.bootcamp.kafkaservice.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class kafkaProducer {
    private static final Logger LOGGER = LoggerFactory.getLogger(kafkaProducer.class);
    private final KafkaTemplate<String, String> kafkaTemplate;
    public kafkaProducer(@Qualifier("kafkaStringTemplate") KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }
    public void sendMessage(String message) {
        LOGGER.info("Producing message {}", message);
        this.kafkaTemplate.send("TOPIC-DEMO", message);
    }
}
