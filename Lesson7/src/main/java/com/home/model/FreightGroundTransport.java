package com.home.model;

import com.home.enums.TransportType;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import static com.home.enums.TransportType.FREIGHT;

@Getter
@Setter
@SuperBuilder
public class FreightGroundTransport extends GroundTransport {
    private Integer carrying;

    @Override
    public TransportType getType() {
        return FREIGHT;
    }

    @Override
    public String info() {
        return "FreightGroundTransport{" +
                super.info() +
                ", carrying=" + carrying +
                '}';
    }
}
