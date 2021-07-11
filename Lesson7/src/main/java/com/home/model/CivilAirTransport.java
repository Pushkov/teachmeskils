package com.home.model;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import static com.home.util.CalculationsUtils.powerToHP;

@Getter
@Setter
@SuperBuilder
public class CivilAirTransport extends AirTransport {
    private Integer passengersCount;
    private boolean isBusinessClassAvailable;

    @Override
    public String toString() {
        return "CivilAirTransport{" +
                "model='" + getModel() + "', " +
                "power=" + getPower() + "kW (" + powerToHP(getPower()) + " hp), " +
                "mass=" + getMass() + "кг, " +
                "maximalSpeed=" + getMaximalSpeed() + "км/ч, " +
                "airstripMinSize=" + getAirstripMinSize() + "м, " +
                "wingSize=" + getWingSize() + "м, " +
                "passengersCount=" + getPassengersCount() + ", " +
                "isBusinessClassAvailable=" + isBusinessClassAvailable() +
                "}";
    }
}
