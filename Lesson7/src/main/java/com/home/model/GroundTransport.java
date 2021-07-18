package com.home.model;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
public abstract class GroundTransport extends Transport {
    private Integer wheelCount;
    private Integer fuelConsumption;

    @Override
    public String info() {
        return super.info() +
                ", wheelCount=" + wheelCount +
                ", fuelConsumption=" + fuelConsumption;
    }
}
