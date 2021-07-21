package com.home.model;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
public abstract class AirTransport extends Transport {
    private Integer airstripMinSize;
    private Integer wingSize;

    public String info() {
        return super.info() +
                ", airstripMinSize=" + airstripMinSize +
                ", wingSize=" + wingSize;
    }

}
