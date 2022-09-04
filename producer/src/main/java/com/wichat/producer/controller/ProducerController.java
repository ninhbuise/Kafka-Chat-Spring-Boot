package com.wichat.producer.controller;

import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wichat.producer.model.TopicMessage;

@RestController
@RequestMapping("api/v1")
public class ProducerController {
    @Value("${spring.kafka.template.default-topic}")
    private String topic;
    
    @Autowired
    private KafkaTemplate<String, TopicMessage> kafkaTemplate;

    @PostMapping(value = "/send", consumes = "application/json", produces = "application/json")
    public void sendMessage(@RequestBody TopicMessage topicMessage) {
        try {
            //Sending the message to kafka topic queue
            kafkaTemplate.send(topic, topicMessage).get();
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
    }

}
