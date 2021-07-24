package com.home.model.wear;

import com.home.enums.WearColors;
import com.home.enums.WearType;

public interface IWear {
    WearType getWearType();
    WearColors getColor();
}
