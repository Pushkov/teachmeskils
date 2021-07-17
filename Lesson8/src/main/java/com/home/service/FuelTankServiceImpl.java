package com.home.service;

import com.home.exeptions.NoFreeVolumeInFuelTankExeption;
import com.home.model.FuelTank;

import static com.home.utils.HomeWork8Utils.getEnding;

public class FuelTankServiceImpl implements FuelTankService {
    private final FuelTank fuelTank;

    public FuelTankServiceImpl(FuelTank fuelTank) {
        this.fuelTank = fuelTank;
    }

    @Override
    public boolean isEmpty() {
        return getFuelLevel() == 0;
    }

    @Override
    public int getCapacity() {
        return fuelTank.getFuelCapacity();
    }

    @Override
    public int getFuelLevel() {
        return fuelTank.getFuelLevel();
    }

    @Override
    public int refuel() {
        int refuelVolume = fuelTank.getFuelCapacity() - fuelTank.getFuelLevel();
        fuelTank.setFuelLevel(fuelTank.getFuelCapacity());
        return refuelVolume;
    }

    @Override
    public int refuel(int fuelVolume) throws NoFreeVolumeInFuelTankExeption {
        int emptyVolume = getCapacity() - getFuelLevel();
        int resultRefuelVolume;
        if (fuelVolume > emptyVolume) {
            throw new NoFreeVolumeInFuelTankExeption("Вы хотите залить " + fuelVolume + " литр" + getEnding(fuelVolume) + " топлива,"
                    + " а свободного объема только " + emptyVolume + " литр" + getEnding(emptyVolume));
        } else {
            fuelTank.setFuelLevel(getFuelLevel() + fuelVolume);
            resultRefuelVolume = fuelVolume;
        }
        return resultRefuelVolume;
    }
}
