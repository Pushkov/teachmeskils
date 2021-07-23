package com.home.model.wear.dress;

import com.home.enums.DressType;
import com.home.enums.WearColors;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode
public class OfficeDress implements IDress {
    private final WearColors color;

    public OfficeDress(WearColors color) {
        this.color = color;
    }

    @Override
    public WearColors getColor() {
        return this.color;
    }

    @Override
    public DressType getJacketType() {
        return DressType.OFFICE;
    }
}
