package com.home.service;

import com.home.model.Engine;

public class EngineServiceImpl implements EngineService {

    private final Engine engine;

    public EngineServiceImpl(Engine engine) {
        this.engine = engine;
    }

    @Override
    public void start() {
        if (!isRunning()) {
            engine.setRunning(true);
            System.out.println("��������� �������");
        } else {
            System.out.println("��������� ��� ��������");
        }
    }

    @Override
    public void stop() {
        if (isRunning()) {
            engine.setRunning(false);
            System.out.println("��������� ��������");
        } else {
            System.out.println("��������� ��� �� ��������");
        }
    }

    @Override
    public boolean isRunning() {
        return engine.isRunning();
    }
}
