package com.bootcamp.kafkaservice.infraestructure;

import com.bootcamp.kafkaservice.model.User;
import com.bootcamp.kafkaservice.producer.kafkaProducer;
import com.bootcamp.kafkaservice.producer.kafkaProducerJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/kafka")
public class kafkaController {
    private final kafkaProducer kafkaProducer;
    private final kafkaProducerJson kafkaProducerJson;

    @Autowired
    kafkaController(kafkaProducer kafkaProducer,kafkaProducerJson kafkaProducerJson) {
        this.kafkaProducer = kafkaProducer;
        this.kafkaProducerJson = kafkaProducerJson;
    }
    @PostMapping(value = "/publish")
    public void sendMessageToKafkaTopic(@RequestParam("message") String message) {
        this.kafkaProducer.sendMessage(message);
    }
    @PostMapping(value = "/publish/json")
    public void SendJsonToKafkaTopic(@RequestBody User u) {
        this.kafkaProducerJson.sendMessage(u);
    }
}
