package com.home.service;

public class EngineServiceImpl implements EngineService {
    @Override
    public void start() {
        System.out.println("Двигатель заведен");
    }

    @Override
    public void stop() {
        System.out.println("Двигатель заглушен");
    }
}
