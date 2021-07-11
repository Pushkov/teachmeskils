package com.home.model;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
public class AirTransport extends Transport {
    private Integer airstripMinSize;
    private Integer wingSize;

    public void info() {
        System.out.println("airTransport");
    }
}
