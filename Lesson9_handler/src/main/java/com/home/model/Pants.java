package com.home.model;

import com.home.enums.WearType;
import com.home.interfaces.IWear;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode
public class Pants implements IWear {
    @Override
    public WearType getType() {
        return WearType.PANTS;
    }

    @Override
    public void putOn() {
        System.out.println("Штаны надеты");
    }

    @Override
    public void takeOff() {
        System.out.println("Штаны сняты");
    }
}
