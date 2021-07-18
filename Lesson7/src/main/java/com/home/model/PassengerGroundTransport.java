package com.home.model;

import com.home.enums.TransportType;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import static com.home.enums.TransportType.PASSENGER;

@Getter
@Setter
@SuperBuilder
public class PassengerGroundTransport extends GroundTransport {
    private Integer passengersCount;
    private String bodyType;

    @Override
    public TransportType getType() {
        return PASSENGER;
    }

    @Override
    public String info() {
        return "PassengerGroundTransport{" +
                super.info() +
                ", passengersCount=" + passengersCount +
                ", bodyType='" + bodyType + '\'' +
                '}';
    }
}
