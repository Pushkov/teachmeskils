package com.home.model.wear.shoes;

import com.home.enums.ShoesType;
import com.home.enums.WearColors;
import lombok.EqualsAndHashCode;

import static com.home.enums.ShoesType.DANCING;

@EqualsAndHashCode
public class DancingShoes implements IShoes {
    private final WearColors color;

    public DancingShoes(WearColors color) {
        this.color = color;
    }

    @Override
    public WearColors getColor() {
        return this.color;
    }

    @Override
    public ShoesType getShoesType() {
        return DANCING;
    }
}
