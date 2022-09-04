package com.wichat.producer.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TopicMessage {
    private String topic;
    private String message;
}
