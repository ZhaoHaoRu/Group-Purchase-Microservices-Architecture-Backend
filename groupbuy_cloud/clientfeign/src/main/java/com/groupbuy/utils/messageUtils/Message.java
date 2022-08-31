package com.groupbuy.utils.messageUtils;

public class Message<T> {
    private int status;
    private String message;
    private T data;

    Message(int status, String message, T data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    Message(int status, String message) {
        this.status = status;
        this.message = message;
        this.data = null;
    }

    Message(Message<T> message) {
        this.status = message.status;
        this.message = message.message;
        this.data = message.data;
    }

//    Message() {}

    public String getMessage() {
        return message;
    }

    public int getStatus() {
        return status;
    }

    public T getData() {
        return data;
    }
}
