package com.home.service;

public interface CarService {
    void startEngine();

    void go();

    void stop();

    void stopEngine();

    int getTraveledDistance();

    int getFuelLevel();

}
