package com.home.service.people;

import com.home.model.wear.IWear;

public interface IWomanService {

    void takeItem(IWear item);
    void putOn(IWear item);
    void takeOff(IWear item);
    IWear refuseDress(IWear item);
    boolean isWomanPleased();
    String dressingInfo();
}
