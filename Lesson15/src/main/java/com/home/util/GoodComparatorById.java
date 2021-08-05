package com.home.util;

import com.home.model.Good;

import java.util.Comparator;

public class GoodComparatorById implements Comparator<Good> {
    @Override
    public int compare(Good a, Good b) {
        return a.getId() > b.getId() ? 1 : -1;
    }
}
