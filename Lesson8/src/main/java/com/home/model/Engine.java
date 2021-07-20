package com.home.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Engine {
    private boolean isRunning;
    private String type;
    private int workingVolume;

    public Engine(String type, int workingVolume) {
        this.type = type;
        this.workingVolume = workingVolume;
    }
}
