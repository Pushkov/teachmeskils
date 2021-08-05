package com.home.util;

import com.home.model.Good;

import java.util.Comparator;

public class GoodComparatorByPrice implements Comparator<Good> {
    @Override
    public int compare(Good a, Good b) {
        return Integer.compare(a.getPrice(), b.getPrice());
    }
}
