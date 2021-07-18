package com.home;

import com.home.model.*;
import com.home.service.TransportSelectorService;
import com.home.service.TransportService;

import java.util.ArrayList;
import java.util.List;

public class HomeWork7 {
    private static List<Transport> transportList = initListOfTransport();

    public static void main(String[] args) {
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
                .mass(10000)
                .power(10000)
                .maximalSpeed(1100)
                .airstripMinSize(2000)
                .wingSize(24)
                .passengersCount(150)
                .isBusinessClassAvailable(true)
                .build());
        transportList.add(MilitaryAirTransport.builder()
                .model("MIG")
                .mass(8000)
                .power(8200)
                .maximalSpeed(1900)
                .airstripMinSize(1500)
                .wingSize(18)
                .rocketCount(10)
                .isCatapultAvailable(true)
                .build());
        transportList.add(PassengerGroundTransport.builder()
                .model("Audi")
                .mass(1700)
                .power(150)
                .maximalSpeed(200)
                .wheelCount(4)
                .fuelConsumption(8)
                .passengersCount(5)
                .bodyType("седан")
                .build());
        transportList.add(FreightGroundTransport.builder()
                .model("Scania")
                .mass(8000)
                .power(450)
                .maximalSpeed(110)
                .wheelCount(6)
                .fuelConsumption(20)
                .carrying(24000)
                .build());
        return transportList;
    }
}
