package com.wichat.producer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wichat.producer.model.TopicMessage;
import com.wichat.producer.service.KafkaSenderService;

@RestController
@RequestMapping("/producer")
public class ProducerController {

    @Autowired
    KafkaSenderService kafkaSenderService;
    
    @PostMapping("/send")
    public void sendMessage(TopicMessage message) {
        kafkaSenderService.sendMessage(message.getMessage(), message.getTopic());
    }

}
