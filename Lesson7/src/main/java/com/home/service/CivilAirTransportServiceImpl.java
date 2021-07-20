package com.home.service;

import com.home.model.CivilAirTransport;

import static com.home.util.CalculationsUtils.readDataFromConsole;

public class CivilAirTransportServiceImpl implements TransportService {
    private final CivilAirTransport civilAirTransport;

    public CivilAirTransportServiceImpl(CivilAirTransport civilAirTransport) {
        this.civilAirTransport = civilAirTransport;
    }

    @Override
    public void basicAction() {
        int countPassengers = (int) readDataFromConsole("Введите число пассажиров");
        if (countPassengers > civilAirTransport.getPassengersCount()) {
            System.out.println("Вам нужен самолет побольше");
        } else {
            System.out.println("Самолет загружен");
        }
    }

    @Override
    public void advancedAction() {
        double airstripLength = readDataFromConsole("Введите длину взлетно-посадочной полосы аэродрома");
        if (airstripLength > civilAirTransport.getAirstripMinSize()) {
            System.out.println("Вам нужен другой аэродром");
        } else {
            System.out.println("Самолет может совершить взлет/посадку ");
        }
    }
}
