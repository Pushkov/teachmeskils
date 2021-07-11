package com.home.model;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
public class GroundTransport extends Transport {
    private Integer wheelCount;
    private Integer fuelConsumption;
}
