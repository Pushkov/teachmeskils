package com.home.service;

import com.home.exceptions.NoFreeVolumeInFuelTankException;
import com.home.model.Car;

import static com.home.utils.HomeWork8Utils.getEndingForRefueling;

public class CarServiceImpl implements CarService {
    private final Car car;
    private final EngineService engineService;
    private final FuelTankService fuelTankService;

    public CarServiceImpl(Car car) {
        this.car = car;
        this.engineService = new EngineServiceImpl(car.getEngine());
        this.fuelTankService = new FuelTankServiceImpl(car.getFuelTank());
    }

    @Override
    public void carInfo() {
        System.out.println(car);
    }

    @Override
    public boolean isEngineRunning() {
        return engineService.isRunning();
    }

    public void startEngine() {
        if (!isEngineRunning() && !isFuelEmpty()) {
            engineService.start();
        } else if (isEngineRunning()) {
            System.out.println("Двигатель уже работает");
        } else if (isFuelEmpty()) {
            System.out.println("Заправьте автомобиль");
        }
    }

    public void stopEngine() {
        if (isEngineRunning() && !isMoving()) {
            engineService.stop();
        } else if (!isEngineRunning()) {
            System.out.println("Двигатель не заведен");
        } else if (isMoving()) {
            System.out.println("Сначала остановите автомобиль");
        }
    }

    public void startMoving() {
        if (isEngineRunning()) {
            setCarMoving(true);
            setCarCurrentSpeed();
            System.out.println("Автомобиль поехал со скоростью " + car.getCurrentSpeed() + " км/ч");
        } else {
            System.out.println("Заведите двигатель");
        }
    }

    public void stopMoving() {
        if (isMoving()) {
            setCarMoving(false);
            int distance = car.getCurrentSpeed() * 2; // машина ехала 2 часа для примера
            car.setTraveledDistance(distance);
            updateTotalTraveledDistance(distance);
            System.out.println("Автомобиль остановился.");
        }
    }

    @Override
    public boolean isMoving() {
        return car.isMoving();
    }

    @Override
    public boolean isFuelEmpty() {
        return fuelTankService.isEmpty();
    }

    public void viewFuelLevel() {
        System.out.println("Текущий уровень топлива: " + fuelTankService.getFuelLevel());
    }

    @Override
    public void refueling() {
        int refuelVolume = fuelTankService.refuel();
        System.out.println("Автомобиль заправлен " + refuelVolume + " литр" + getEndingForRefueling(refuelVolume) + " топлива.");
    }

    @Override
    public void refueling(int fuelVolume) {
        try {
            int refuelVolume = fuelTankService.refuel(fuelVolume);
            System.out.println("Автомобиль заправлен " + refuelVolume + " литр" + getEndingForRefueling(refuelVolume) + " топлива.");
        } catch (NoFreeVolumeInFuelTankException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void showCurrentTraveledDistance() {
        System.out.println("Расстояние последней поездки: " + car.getTraveledDistance() + " км.");
    }

    @Override
    public void showTotalTraveledDistance() {
        System.out.println("Общий пробег автомобиля: " + car.getTotalTraveledDistance() + " км.");
    }

    private void updateTotalTraveledDistance(int distance) {
        car.setTotalTraveledDistance(car.getTotalTraveledDistance() + distance);
    }

    private void setCarMoving(boolean isMove) {
        car.setMoving(isMove);
    }

    private void setCarCurrentSpeed() {
        car.setCurrentSpeed((int) (Math.random() * car.getMaxSpeed()));
    }
}
