package com.wichat.producer.controller;

import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wichat.producer.constants.KafkaConstants;
import com.wichat.producer.model.TopicMessage;

@RestController
@RequestMapping("api/v1")
public class ProducerController {

    @Autowired
    private KafkaTemplate<String, Object> topicMessageKafkaTemplate;

    @PostMapping(value = "/send")
    public void sendMessage(@RequestBody TopicMessage topicMessage) {
        try {
            //Sending the message to kafka topic queue
            topicMessageKafkaTemplate.send(KafkaConstants.KAFKA_TOPIC, topicMessage).get();
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
    }

}
