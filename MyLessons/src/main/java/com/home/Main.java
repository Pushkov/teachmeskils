package com.home;

import com.home.model.Car;
import com.home.model.Engine;
import com.home.model.FuelTank;
import com.home.service.CarService;
import com.home.service.CarServiceImpl;

public class Main {
    public static void main(String[] args) {
        FuelTank fuelTank = new FuelTank(60);
        Engine engine = new Engine("gasoline", 3000);
        Car car1 = new Car(engine);
        car1.setFuelTank(fuelTank);

        CarService carService = new CarServiceImpl(car1);

        carService.go();
        carService.startEngine();
        carService.refueling();
        carService.startEngine();
        carService.go();
    }
}
