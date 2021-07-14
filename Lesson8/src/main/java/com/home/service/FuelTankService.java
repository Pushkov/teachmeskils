package com.home.service;

public interface FuelTankService {
    boolean isEmpty();
    int getCapacity();
    int getFuelLevel();
    int refuel();
    int refuel(int fuelVolume);
}
