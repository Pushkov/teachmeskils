package com.home.service;

import com.home.model.FuelTank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class FuelServiceImpl implements FuelService {
    private FuelTank fuelTank;

    @Override
    public boolean isEmpty() {
        return fuelTank.getFuelLevel() == 0;
    }

    @Override
    public void refuel() {
        fuelTank.setFuelLevel(fuelTank.getVolume());
    }
}
