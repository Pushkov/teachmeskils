package com.home.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class FuelTank {
    private int fuelLevel;
    private int fuelCapacity;

    public FuelTank(int fuelCapacity) {
        this.fuelCapacity = fuelCapacity;
    }
}
