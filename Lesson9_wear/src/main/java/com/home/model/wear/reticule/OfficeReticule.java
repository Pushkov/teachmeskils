package com.home.model.wear.reticule;

import com.home.enums.ReticuleType;
import com.home.enums.WearColors;
import lombok.EqualsAndHashCode;

import static com.home.enums.ReticuleType.OFFICE;

@EqualsAndHashCode
public class OfficeReticule implements IReticule {
    private final WearColors color;

    public OfficeReticule(WearColors color) {
        this.color = color;
    }

    @Override
    public WearColors getColor() {
        return this.color;
    }

    @Override
    public ReticuleType getPantsType() {
        return OFFICE;
    }
}
