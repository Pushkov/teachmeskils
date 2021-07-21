package com.home.service;

import com.home.model.FreightGroundTransport;

import static com.home.util.CalculationsUtils.readDataFromConsole;

public class FreightGroundTransportServiceImpl implements TransportService {

    private final FreightGroundTransport freightGroundTransport;

    public FreightGroundTransportServiceImpl(FreightGroundTransport freightGroundTransport) {
        this.freightGroundTransport = freightGroundTransport;
    }

    @Override
    public void basicAction() {
        double mass = readDataFromConsole("Введите массу груза, требующего перевозки, в кг");
        if (mass > freightGroundTransport.getCarrying()) {
            System.out.println("Вам нужен грузовик побольше");
        } else {
            System.out.println("Грузовик загружен");
        }
    }

    @Override
    public void advancedAction() {
        System.out.println("  У грузового автомобиля нет дополнительных функций");
    }
}
