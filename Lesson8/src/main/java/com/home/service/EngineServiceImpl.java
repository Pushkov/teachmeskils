package com.home.service;

public class EngineServiceImpl implements EngineService {
    @Override
    public void start() {
        System.out.println("��������� �������");
    }

    @Override
    public void stop() {
        System.out.println("��������� ��������");
    }
}
