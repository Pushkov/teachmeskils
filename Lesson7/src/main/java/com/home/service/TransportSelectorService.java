package com.home.service;

import com.home.model.*;

public class TransportSelectorService {
    public TransportService createService(Transport transport) {
        TransportService service = null;
        switch (transport.getType()) {
            case CIVIL:
                service = new CivilAirTransportServiceImpl((CivilAirTransport) transport);
                break;
            case MILITARY:
                service = new MilitaryAirTransportServiceImpl((MilitaryAirTransport) transport);
                break;
            case FREIGHT:
                service = new FreightGroundTransportServiceImpl((FreightGroundTransport) transport);
                break;
            case PASSENGER:
                service = new PassengersGroundTransportServiceImpl((PassengerGroundTransport) transport);
                break;
        }
        return service;
    }
}
