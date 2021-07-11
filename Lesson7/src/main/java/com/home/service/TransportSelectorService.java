package com.home.service;

import com.home.model.*;

public class TransportSelectorService {
    public TransportService createService(Transport transport) {
        TransportService service = null;
        if (transport instanceof PassengerGroundTransport) {
            service = new PassengersGroundTransportServiceImpl((PassengerGroundTransport) transport);
        } else if (transport instanceof FreightGroundTransport) {
            service = new FreightGroundTransportServiceImpl((FreightGroundTransport) transport);
        } else if (transport instanceof CivilAirTransport) {
            service = new CivilAirTransportServiceImpl((CivilAirTransport) transport);
        } else if (transport instanceof MilitaryAirTransport) {
            service = new MilitaryAirTransportServiceImpl((MilitaryAirTransport) transport);
        }
        return service;
    }
}
