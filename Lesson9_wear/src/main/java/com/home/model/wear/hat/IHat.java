package com.home.model.wear.hat;

import com.home.enums.HatType;
import com.home.enums.WearType;
import com.home.model.wear.IWear;

public interface IHat extends IWear {
    HatType getHatType();
    default WearType getWearType(){
        return WearType.HAT;
    }

}
