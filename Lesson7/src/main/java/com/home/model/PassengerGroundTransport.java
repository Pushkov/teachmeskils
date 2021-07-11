package com.home.model;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import static com.home.util.CalculationsUtils.powerToHP;

@Getter
@Setter
@SuperBuilder
public class PassengerGroundTransport extends GroundTransport {
    private Integer passengersCount;
    private String bodyType;

    @Override
    public String toString() {
        return "PassengerGroundTransport{" +
                "model='" + getModel() + "', " +
                "power=" + getPower() + "kW (" + powerToHP(getPower()) + " hp), " +
                "mass=" + getMass() + "кг, " +
                "maximalSpeed=" + getMaximalSpeed() + "км/ч, " +
                "wheelCount=" + getWheelCount() + ", " +
                "fuelConsumption=" + getFuelConsumption() + "л/км, " +
                "passengersCount=" + getPassengersCount() + ", " +
                "bodyType=" + getBodyType() +
                "}";
    }
}
