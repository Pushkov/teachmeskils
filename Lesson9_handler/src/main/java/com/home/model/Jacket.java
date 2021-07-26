package com.home.model;

import com.home.enums.WearType;
import com.home.interfaces.IWear;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode
public class Jacket implements IWear {

    @Override
    public WearType getType() {
        return WearType.JACKET;
    }

    @Override
    public void putOn() {
        System.out.println("Куртка надета");
    }

    @Override
    public void takeOff() {
        System.out.println("Куртка снята");
    }
}
