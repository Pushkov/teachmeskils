package com.home.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Car {
    private String model;
    private String color;
    private int yearOfIssue;
    private int traveledDistance;
    private int totalTraveledDistance;
    private boolean isMoving;
    private int maxSpeed;
    private int currentSpeed;
    private final Engine engine;
    private final FuelTank fuelTank;

    public Car(Engine engine, FuelTank fuelTank) {
        this.engine = engine;
        this.fuelTank = fuelTank;
    }


}
