package com.home.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Engine {
    private final String type;
    private final int workVolume;
    private boolean isRunning;

    public Engine(String type, int workVolume) {
        this.type = type;
        this.workVolume = workVolume;
    }

}
