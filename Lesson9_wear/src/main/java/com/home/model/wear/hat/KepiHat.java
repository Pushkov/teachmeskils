package com.home.model.wear.hat;

import com.home.enums.HatType;
import com.home.enums.WearColors;

import static com.home.enums.HatType.KEPI;

public class KepiHat implements IHat {
    private final WearColors color;

    public KepiHat(WearColors color) {
        this.color = color;
    }

    @Override
    public HatType getHatType() {
        return KEPI;
    }

    @Override
    public WearColors getColor() {
        return this.color;
    }
}
