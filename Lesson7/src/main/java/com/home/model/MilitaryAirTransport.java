package com.home.model;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import static com.home.util.CalculationsUtils.powerToHP;

@Getter
@Setter
@SuperBuilder
public class MilitaryAirTransport extends AirTransport {
    private Integer rocketCount;
    private boolean isCatapultAvailable;

    @Override
    public String toString() {
        return "MilitaryAirTransport{" +
                "model='" + getModel() + "', " +
                "power=" + getPower() + "kW (" + powerToHP(getPower()) + " hp), " +
                "mass=" + getMass() + "кг, " +
                "maximalSpeed=" + getMaximalSpeed() + "км/ч, " +
                "airstripMinSize=" + getAirstripMinSize() + "м, " +
                "wingSize=" + getWingSize() + "м, " +
                "rocketCount=" + getRocketCount() + ", " +
                "isCatapultAvailable=" + isCatapultAvailable() +
                "}";
    }

}
