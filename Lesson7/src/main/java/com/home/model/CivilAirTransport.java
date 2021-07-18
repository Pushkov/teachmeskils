package com.home.model;

import com.home.enums.TransportType;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import static com.home.enums.TransportType.CIVIL;

@Getter
@Setter
@SuperBuilder
public class CivilAirTransport extends AirTransport {
    private Integer passengersCount;
    private boolean isBusinessClassAvailable;

    @Override
    public TransportType getType() {
        return CIVIL;
    }

    @Override
    public String info() {
        return "CivilAirTransport{" +
                super.info() +
                ", passengersCount=" + getPassengersCount() +
                ", isBusinessClassAvailable=" + isBusinessClassAvailable() +
                "}";
    }
}
