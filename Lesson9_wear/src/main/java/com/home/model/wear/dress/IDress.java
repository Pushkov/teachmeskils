package com.home.model.wear.dress;

import com.home.enums.DressType;
import com.home.enums.WearType;
import com.home.model.wear.IWear;

public interface IDress extends IWear {
    DressType getJacketType();
    default WearType getWearType(){
        return WearType.DRESS;
    }
}
