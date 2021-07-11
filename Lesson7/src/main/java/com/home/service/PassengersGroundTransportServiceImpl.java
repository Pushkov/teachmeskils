package com.home.service;

import com.home.model.PassengerGroundTransport;

import static com.home.util.CalculationsUtils.getMovingTime;

public class PassengersGroundTransportServiceImpl implements TransportService {

    private final PassengerGroundTransport passengerGroundTransport;

    public PassengersGroundTransportServiceImpl(PassengerGroundTransport passengerGroundTransport) {
        this.passengerGroundTransport = passengerGroundTransport;
    }

    @Override
    public void basicAction() {
        double movingTime = getMovingTime();
        System.out.println("> " + movingTime);
        System.out.printf("  За время %f ч, автомобиль %s\n" +
                        "двигаясь с максимальной скоростью %d км/ч\n" +
                        "проедет %f км и израсходует %f литров топлива.\n",
                movingTime,
                passengerGroundTransport.getModel(),
                passengerGroundTransport.getMaximalSpeed(),
                getMovingDistance(movingTime),
                getFuelConsumption(movingTime)
        );
    }

    @Override
    public void advancedAction() {
        System.out.println("  У легкового автомобиля нет дополнительных функций");
    }

    private double getMovingDistance(double movingTime) {
        return passengerGroundTransport.getMaximalSpeed() * movingTime;
    }

    private double getFuelConsumption(double movingTime) {
        return movingTime * passengerGroundTransport.getMaximalSpeed() * passengerGroundTransport.getFuelConsumption();
    }
}
