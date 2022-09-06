package com.wichat.producer.listener;

import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.gson.Gson;
import com.wichat.producer.constants.KafkaConstants;
import com.wichat.producer.model.TopicMessage;

@Component
public class MessageListener {

    private static final Logger logger = LoggerFactory.getLogger(TopicMessage.class);

	@KafkaListener(groupId = KafkaConstants.GROUP_ID_JSON, topics = KafkaConstants.KAFKA_TOPIC, containerFactory = "kafkaListenerContainerFactory")
	public void receivedMessage(String message) throws JsonProcessingException {
		Gson gson = new Gson();
		ByteBuffer buffer = StandardCharsets.UTF_8.encode(message); 
		String utf8EncodedString = StandardCharsets.UTF_8.decode(buffer).toString();
		
		TopicMessage topicMessage = gson.fromJson(utf8EncodedString, TopicMessage.class);
		logger.info("Json message received using Kafka listener " + topicMessage);
	}
}
