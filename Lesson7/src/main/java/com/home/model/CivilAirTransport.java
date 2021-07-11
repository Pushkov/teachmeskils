package com.home.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import static com.home.util.CalculationsUtils.powerToHP;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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
