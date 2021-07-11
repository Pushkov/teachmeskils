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
