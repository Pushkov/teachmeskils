package com.home.service;

import com.home.model.MilitaryAirTransport;

public class MilitaryAirTransportServiceImpl implements TransportService {
    private final MilitaryAirTransport militaryAirTransport;

    public MilitaryAirTransportServiceImpl(MilitaryAirTransport militaryAirTransport) {
        this.militaryAirTransport = militaryAirTransport;
    }

    @Override
    public void basicAction() {
        if (militaryAirTransport.getRocketCount() > 0) {
            militaryAirTransport.setRocketCount(militaryAirTransport.getRocketCount() - 1);
            System.out.println("Ракета пошла");
        } else {
            System.out.println("Боеприпасы отсутствуют");
        }
    }

    @Override
    public void advancedAction() {
        if (militaryAirTransport.isCatapultAvailable()) {
            System.out.println("Катапультирование прошло успешно");
        } else {
            System.out.println("У вас нет такой системы");
        }
    }
}
