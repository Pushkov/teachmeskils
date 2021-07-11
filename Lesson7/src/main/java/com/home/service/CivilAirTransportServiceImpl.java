package com.home.service;

import com.home.model.CivilAirTransport;

public class CivilAirTransportServiceImpl implements TransportService {
    private final CivilAirTransport civilAirTransport;

    public CivilAirTransportServiceImpl(CivilAirTransport civilAirTransport) {
        this.civilAirTransport = civilAirTransport;
    }

    @Override
    public void basicAction() {

    }

    @Override
    public void advancedAction() {

    }
}
