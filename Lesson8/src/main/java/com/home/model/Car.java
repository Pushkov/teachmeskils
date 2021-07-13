package com.home.model;

public class Car {
    private String model;
    private int yearOfIssue;
    private int traveledDistance;
    private int totalTraveledDistance;

    private Engine engine;
    private FuelTank fuelTank;

    public Car(Engine engine, FuelTank fuelTank) {
        this.engine = engine;
        this.fuelTank = fuelTank;
    }
}
