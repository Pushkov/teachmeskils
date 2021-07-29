package com.home.service;

import com.home.model.Engine;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class EngineServiceImpl implements EngineService {
    private final Engine engine;

    @Override
    public boolean isRuning() {
        return engine.isRunning();
    }

    @Override
    public void start() {
        if (!isRuning()) {
            this.engine.setRunning(true);
            System.out.println("Двигатель запустился");
        } else {
            System.out.println("Двигатель уже работает");
        }
    }

    @Override
    public void stop() {
        if (isRuning()) {
            this.engine.setRunning(false);
            System.out.println("Двигатель заглушен");
        } else {
            System.out.println("Двигатель уже не работает");
        }
    }
}
