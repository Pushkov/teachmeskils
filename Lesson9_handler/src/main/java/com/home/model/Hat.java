package com.home.model;

import com.home.enums.WearType;
import com.home.interfaces.IWear;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode
public class Hat implements IWear {

    @Override
    public WearType getType() {
        return WearType.HUT;
    }

    @Override
    public void putOn() {
        System.out.println("Шапка надета");
    }

    @Override
    public void takeOff() {
        System.out.println("Шапка снята");
    }
}
