package com.home.model.wear.hat;

import com.home.enums.HatType;
import com.home.enums.WearColors;
import lombok.EqualsAndHashCode;

import static com.home.enums.HatType.PANAMA;

@EqualsAndHashCode
public class PanamaHat implements IHat {
    private final WearColors color;

    public PanamaHat(WearColors color) {
        this.color = color;
    }

    @Override
    public HatType getHatType() {
        return PANAMA;
    }

    @Override
    public WearColors getColor() {
        return this.color;
    }
}
