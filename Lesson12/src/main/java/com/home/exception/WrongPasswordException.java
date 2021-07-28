package com.home.exception;

public class WrongPasswordException extends RuntimeException {

    public WrongPasswordException(String message) {
        super(message);
    }

    public WrongPasswordException() {
        super();
    }

    public WrongPasswordException(String message, Throwable cause) {
        super(message, cause);
    }
}
