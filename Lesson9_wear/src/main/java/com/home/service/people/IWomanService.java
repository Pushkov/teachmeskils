package com.home.service.people;

import com.home.model.wear.IWear;

public interface IWomanService {

    void takeItem(IWear item);
    boolean isWomanPleased();
    String dressingInfo();
}
