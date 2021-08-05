package com.home.util;

import com.home.model.Good;

import java.util.Comparator;

public class GoodComparatorByName implements Comparator<Good> {
    @Override
    public int compare(Good a, Good b) {
        return a.getName().toUpperCase().compareTo(b.getName().toUpperCase());
    }
}
