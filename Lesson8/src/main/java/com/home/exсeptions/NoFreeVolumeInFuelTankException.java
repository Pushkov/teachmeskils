package com.home.exсeptions;

public class NoFreeVolumeInFuelTankException extends RuntimeException {
    public NoFreeVolumeInFuelTankException(String message) {
        super(message);
    }
}
