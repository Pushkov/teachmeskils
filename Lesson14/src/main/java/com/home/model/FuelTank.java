package com.home.model;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Getter
@Setter
@ToString
public class FuelTank implements Serializable {
    private final int fuelCapacity;
    private int fuelLevel;

    public FuelTank(int fuelCapacity) {
        this.fuelCapacity = fuelCapacity;
    }
}
