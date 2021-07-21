package com.home.exñeptions;

public class NoFreeVolumeInFuelTankException extends RuntimeException {
    public NoFreeVolumeInFuelTankException(String message) {
        super(message);
    }
}
