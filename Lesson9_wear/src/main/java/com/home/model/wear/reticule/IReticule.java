package com.home.model.wear.reticule;

import com.home.enums.ReticuleType;
import com.home.enums.WearType;
import com.home.model.wear.IWear;

public interface IReticule extends IWear {
    ReticuleType getPantsType();
    default WearType getWearType(){
        return WearType.RETICULE;
    }
}
