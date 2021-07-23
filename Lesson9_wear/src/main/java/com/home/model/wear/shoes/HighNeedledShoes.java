package com.home.model.wear.shoes;

import com.home.enums.ShoesType;
import com.home.enums.WearColors;

import static com.home.enums.ShoesType.HIGHNEEDLED;

public class HighNeedledShoes implements IShoes {
    private final WearColors color;

    public HighNeedledShoes(WearColors color) {
        this.color = color;
    }

    @Override
    public WearColors getColor() {
        return this.color;
    }

    @Override
    public ShoesType getShoesType() {
        return HIGHNEEDLED;
    }
}
