package com.home.interfaces;

import com.home.enums.WearType;

public interface IHuman {

    void takeWear(IWear item);

    void dropWear(WearType type);

    void wearPutOn();

    void wearTakeOff();

    void wearPutOnWears();

    void wearTakeOffWears();

}
