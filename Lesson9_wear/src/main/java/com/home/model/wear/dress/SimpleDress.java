package com.home.model.wear.dress;

import com.home.enums.DressType;
import com.home.enums.WearColors;

public class SimpleDress implements IDress {
    private final WearColors color;

    public SimpleDress(WearColors color) {
        this.color = color;
    }

    @Override
    public WearColors getColor() {
        return this.color;
    }

    @Override
    public DressType getJacketType() {
        return DressType.EVENING;
    }
}
