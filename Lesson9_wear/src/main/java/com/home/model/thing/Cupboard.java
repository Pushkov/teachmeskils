package com.home.model.thing;

import com.home.model.wear.IWear;

import java.util.ArrayList;
import java.util.List;

public class Cupboard implements ICupboard {
    private List<IWear> wears;

    public List<IWear> getWears() {
        if (wears == null) {
            wears = new ArrayList<>();
        }
        return wears;
    }
}
