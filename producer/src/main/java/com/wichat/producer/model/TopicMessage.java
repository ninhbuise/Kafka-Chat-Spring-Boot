package com.wichat.producer.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class TopicMessage {

    private Long roomId;

    private String sender;

    private String content;

}
