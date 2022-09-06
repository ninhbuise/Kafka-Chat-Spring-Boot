package com.wichat.producer.controller;

import java.time.Duration;
import java.util.*;

import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wichat.producer.constants.KafkaConstants;
import com.wichat.producer.model.TopicMessage;

@RestController
@RequestMapping("api/v1/consumer")
public class ConsumerController {

    @Autowired
    private ConsumerFactory<String, TopicMessage> consumerFactory;

    @GetMapping(value = "/message")
    public List<TopicMessage> receiveMessage() {
        List<TopicMessage> messages = new ArrayList<>();
        Consumer<String, TopicMessage> consumer = consumerFactory.createConsumer();
        try {
            consumer.subscribe(Arrays.asList(KafkaConstants.KAFKA_TOPIC));
            ConsumerRecords<String, TopicMessage> consumerRecords = consumer.poll(Duration.ofMillis(10000));
            Iterable<ConsumerRecord<String, TopicMessage>> records = consumerRecords.records(KafkaConstants.KAFKA_TOPIC);
            Iterator<ConsumerRecord<String, TopicMessage>> iterator = records.iterator();

            while (iterator.hasNext())
                messages.add(iterator.next().value());

        } catch (Exception e) {
            e.printStackTrace();
        }
        return messages;
    }
}
