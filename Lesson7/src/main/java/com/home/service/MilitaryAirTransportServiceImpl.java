package com.home.service;

import com.home.model.MilitaryAirTransport;

public class MilitaryAirTransportServiceImpl implements TransportService {
    private final MilitaryAirTransport militaryAirTransport;

    public MilitaryAirTransportServiceImpl(MilitaryAirTransport militaryAirTransport) {
        this.militaryAirTransport = militaryAirTransport;
    }

    @Override
    public void basicAction() {

    }

    @Override
    public void advancedAction() {

    }
}
