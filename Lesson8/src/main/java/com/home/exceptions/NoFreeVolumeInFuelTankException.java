package com.home.exceptions;

public class NoFreeVolumeInFuelTankException extends RuntimeException {
    public NoFreeVolumeInFuelTankException(String message) {
        super(message);
    }
}
