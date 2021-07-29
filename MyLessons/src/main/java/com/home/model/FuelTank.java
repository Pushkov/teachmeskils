package com.home.model;

//import lombok.Getter;
//import lombok.Setter;
//
//@Getter
//@Setter
public class FuelTank {
    private final int volume;
    private int fuelLevel;

    public FuelTank(int volume) {
        this.volume = volume;
    }

    public int getVolume() {
        return volume;
    }

    public int getFuelLevel() {
        return fuelLevel;
    }

    public void setFuelLevel(int fuelLevel) {
        this.fuelLevel = fuelLevel;
    }
}
