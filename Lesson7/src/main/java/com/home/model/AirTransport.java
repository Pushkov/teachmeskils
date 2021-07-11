package com.home.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AirTransport extends Transport {
    private Integer airstripMinSize;
    private Integer wingSize;

    public void info() {
        System.out.println("airTransport");
    }
}
