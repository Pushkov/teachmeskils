package com.home.service;

public interface CarService {
    void carInfo();

    boolean isEngineRunning();

    boolean isMoving();

    void startEngine();

    void startMoving();

    void stopMoving();

    void stopEngine();

    boolean isFuelEmpty();

    void viewFuelLevel();

    void refueling();

    void refueling(int fuelVolume);

    void showCurrentTraveledDistance();

    void showTotalTraveledDistance();
}
