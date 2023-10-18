package com.nighthawk.websocket;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Message {

    private final String from; // changed from StringBuilder to String
    private final String text;

    @JsonCreator 
    public Message(@JsonProperty("from") String from, @JsonProperty("text") String text) {
        this.from = from;
        this.text = text;
    }

    public String getFrom() {
        return from;
    }

    public String getText() {
        return text;
    }
}
