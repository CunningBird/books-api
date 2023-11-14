package com.cunningbird.codereview.exception;

public class BusinessErrorException extends Exception {
    public BusinessErrorException(String message) {
        super(message);
    }
}
