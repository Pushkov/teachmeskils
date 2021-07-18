package com.home.model;

import com.home.enums.TransportType;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import static com.home.enums.TransportType.MILITARY;

@Getter
@Setter
@SuperBuilder
public class MilitaryAirTransport extends AirTransport {
    private Integer rocketCount;
    private boolean isCatapultAvailable;

    @Override
    public TransportType getType() {
        return MILITARY;
    }

    @Override
    public String info() {
        return "MilitaryAirTransport{" +
                super.info() +
                ", rocketCount=" + getRocketCount() +
                ", isCatapultAvailable=" + isCatapultAvailable() +
                "}";
    }
}
