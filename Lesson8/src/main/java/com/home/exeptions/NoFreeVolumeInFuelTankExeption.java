package com.home.exeptions;

public class NoFreeVolumeInFuelTankExeption extends RuntimeException{
    public NoFreeVolumeInFuelTankExeption(String message) {
        super(message);
    }
}
