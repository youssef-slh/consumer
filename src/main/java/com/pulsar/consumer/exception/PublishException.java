package com.pulsar.consumer.exception;

public class PublishException extends RuntimeException {
    public PublishException(String message) {
        super(message);
    }
}
