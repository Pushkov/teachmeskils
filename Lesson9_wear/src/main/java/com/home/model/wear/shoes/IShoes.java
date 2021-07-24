package com.home.model.wear.shoes;

import com.home.enums.ShoesType;
import com.home.enums.WearType;
import com.home.model.wear.IWear;

public interface IShoes extends IWear {
    ShoesType getShoesType();
    default WearType getWearType(){
        return WearType.SHOES;
    }
}
