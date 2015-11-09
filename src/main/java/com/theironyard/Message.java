package com.theironyard;

/**
 * Created by cameronoakley on 11/9/15.
 */
public class Message {
    Integer id;
    String text;

    public Integer getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public Message(Integer id, String text) {

        this.id = id;
        this.text = text;
    }
}
