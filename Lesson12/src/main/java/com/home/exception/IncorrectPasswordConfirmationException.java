package com.home.exception;

public class IncorrectPasswordConfirmationException extends WrongPasswordException {

    public IncorrectPasswordConfirmationException() {
        super();
    }

    public IncorrectPasswordConfirmationException(String message) {
        super(message);
    }
}
