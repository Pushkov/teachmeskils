package com.home.ex�eptions;

public class NoFreeVolumeInFuelTankException extends RuntimeException {
    public NoFreeVolumeInFuelTankException(String message) {
        super(message);
    }
}
