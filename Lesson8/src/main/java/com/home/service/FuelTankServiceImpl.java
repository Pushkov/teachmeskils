package com.home.service;

import com.home.model.FuelTank;

public class FuelTankServiceImpl implements FuelTankService {
    private final FuelTank fuelTank;

    public FuelTankServiceImpl(FuelTank fuelTank) {
        this.fuelTank = fuelTank;
    }

    @Override
    public int getCapacity() {
        return fuelTank.g;
    }

    @Override
    public int getFuelLevel() {
        return 0;
    }

    @Override
    public void refuel() {

    }
}
