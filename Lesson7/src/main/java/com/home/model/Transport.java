package com.home.model;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import static com.home.util.CalculationsUtils.powerToKW;

@Getter
@Setter
@SuperBuilder
public abstract class Transport implements Transportable {
    private String model;
    private double power;
    private Integer mass;
    private Integer maximalSpeed;

    public String info() {
        return "model='" + model + "'" +
                ", power(HP)=" + power +
                ", power(kW)=" + powerToKW(power) +
                ", mass=" + mass +
                ", maximalSpeed=" + maximalSpeed;
    }
}
