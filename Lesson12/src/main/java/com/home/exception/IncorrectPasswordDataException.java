package com.home.exception;

public class IncorrectPasswordDataException extends WrongPasswordException {

    public IncorrectPasswordDataException() {
        super();
    }

    public IncorrectPasswordDataException(String message) {
        super(message);
    }
}
