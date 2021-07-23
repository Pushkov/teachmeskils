package com.home.model.wear.reticule;

import com.home.enums.ReticuleType;
import com.home.enums.WearColors;

import static com.home.enums.ReticuleType.SHOPPING;

public class ShoppingReticule implements IReticule {
    private final WearColors color;

    public ShoppingReticule(WearColors color) {
        this.color = color;
    }

    @Override
    public WearColors getColor() {
        return this.color;
    }

    @Override
    public ReticuleType getPantsType() {
        return SHOPPING;
    }
}
