package com.home;

import com.home.model.*;
import com.home.service.TransportSelectorService;
import com.home.service.TransportService;

import java.util.ArrayList;
import java.util.List;

public class HomeWork7 {
    private static List<Transport> transportList;

    public static void main(String[] args) {
        transportList = initListOfTransport();
        TransportSelectorService transportSelectorService = new TransportSelectorService();
        for (Transport t : transportList) {
            System.out.println();
            TransportService service = transportSelectorService.createService(t);
            System.out.println(t);
            service.basicAction();
            service.advancedAction();
        }
    }

    private static List<Transport> initListOfTransport() {
        List<Transport> transportList = new ArrayList<>();
        transportList.add(CivilAirTransport.builder()
                .model("Airbus")
                .mass(1000)
                .power(1200)
                .maximalSpeed(1100)
                .airstripMinSize(2000)
                .wingSize(24)
                .passengersCount(150)
                .isBusinessClassAvailable(true)
                .build());
        transportList.add(MilitaryAirTransport.builder()
                .model("Airbus")
                .mass(1000)
                .power(1200)
                .maximalSpeed(1100)
                .airstripMinSize(2000)
                .wingSize(24)
                .rocketCount(10)
                .isCatapultAvailable(true)
                .build());
        transportList.add(PassengerGroundTransport.builder()
                .model("Airbus")
                .mass(1000)
                .power(1200)
                .maximalSpeed(1100)
                .wheelCount(4)
                .fuelConsumption(6)
                .passengersCount(150)
                .bodyType("седан")
                .build());
        transportList.add(FreightGroundTransport.builder()
                .model("Airbus")
                .mass(1000)
                .power(1200)
                .maximalSpeed(1100)
                .wheelCount(6)
                .fuelConsumption(20)
                .carrying(24000)
                .build());
        return transportList;
    }
}
