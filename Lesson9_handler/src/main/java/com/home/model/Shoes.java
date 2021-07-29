package com.home.model;

import com.home.enums.WearType;
import com.home.interfaces.IWear;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode
public class Shoes implements IWear {
    @Override
    public WearType getType() {
        return WearType.SHOES;
    }

    @Override
    public void putOn() {
        System.out.println("Ботинки надеты");
    }

    @Override
    public void takeOff() {
        System.out.println("Ботинки сняты");
    }
}
