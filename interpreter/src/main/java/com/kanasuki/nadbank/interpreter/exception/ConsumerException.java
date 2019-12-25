package com.kanasuki.nadbank.interpreter.exception;

public class ConsumerException extends Exception {

    public ConsumerException(String message, Exception e) {
        super(message, e);
    }

    public ConsumerException(String message) {
        super(message);
    }
}
