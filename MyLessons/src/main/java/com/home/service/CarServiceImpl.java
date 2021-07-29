package com.home.service;

import com.home.model.Car;

public class CarServiceImpl implements CarService {
    private final Car car;
    private final EngineService engineService;
    private final FuelService fuelService;

    public CarServiceImpl(Car car) {
        this.car = car;
        this.engineService = new EngineServiceImpl(car.getEngine());
        this.fuelService = new FuelServiceImpl(car.getFuelTank());
    }

    @Override
    public boolean isMoving() {
        return car.isMoving();
    }

    @Override
    public void refueling() {
        fuelService.refuel();
    }

    @Override
    public void go() {
        if (engineService.isRuning()) {
            car.setMoving(true);
            System.out.println("Автомобиль поехал ");
        } else {
            System.out.println("Заведите двигатель");
        }
    }

    @Override
    public void stop() {
        if (isMoving()) {
            car.setMoving(false);
        }
    }

    @Override
    public void startEngine() {
        if (!engineService.isRuning() && !fuelService.isEmpty()) {
            engineService.start();
        } else if (engineService.isRuning()) {
            System.out.println("Двигатель уже работает");
        } else if (fuelService.isEmpty()) {
            System.out.println("Заправьте автомобиль");
        }
    }

    @Override
    public void stopEngine() {
        if (engineService.isRuning() && !isMoving()) {
            engineService.stop();
        } else if (!engineService.isRuning()) {
            System.out.println("Двигатель не заведен");
        } else if (isMoving()) {
            System.out.println("Сначала остановите автомобиль");
        }
    }
}
