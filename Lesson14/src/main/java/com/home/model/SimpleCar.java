package com.home.model;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Getter
@Setter
@ToString
public class SimpleCar implements Serializable {
    private final String model;
    private int maxSpeed;
    private int price;
    private final Engine engine;
    private FuelTank fuelTank;

    public SimpleCar(String model, Engine engine) {
        this.model = model;
        this.engine = engine;
    }
}
