package com.home.service.thing;

import com.home.enums.WearType;
import com.home.model.wear.IWear;

import java.util.List;

public interface ICupboardService {

    int getWearsCountInCupboard();

    void addOneItem(IWear item);

    void addPackItems(List<IWear> items);

    IWear extractItem();

    IWear extractItemByWearType(WearType type);

    void removeAllWears();
}
