package com.wichat.producer.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TopicMessage {

    private Long roomId;

    private String sender;

    private String content;

}
