package com.home.interfaces;

import com.home.enums.WearType;

public interface IWear {

    WearType getType();

    void putOn();

    void takeOff();
}
