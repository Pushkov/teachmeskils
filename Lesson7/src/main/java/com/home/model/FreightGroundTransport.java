package com.home.model;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import static com.home.util.CalculationsUtils.powerToHP;

@Getter
@Setter
@SuperBuilder
public class FreightGroundTransport extends GroundTransport {
    private Integer carrying;

    @Override
    public String toString() {
        return "FreightGroundTransport{" +
                "model='" + getModel() + "', " +
                "power=" + getPower() + "kW (" + powerToHP(getPower()) + " hp), " +
                "mass=" + getMass() + "кг, " +
                "maximalSpeed=" + getMaximalSpeed() + "км/ч, " +
                "wheelCount=" + getWheelCount() + ", " +
                "fuelConsumption=" + getFuelConsumption() + "л/км, " +
                "carrying=" + getCarrying() + "кг , " +
                "}";
    }
}
