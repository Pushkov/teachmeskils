package com.home.model;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

public class Shop {
    @Getter
    @Setter
    private boolean isWorking = true;
    private List<Good> goods;

    public List<Good> getGoods() {
        if (goods == null) {
            goods = new ArrayList<>();
        }
        return goods;
    }
}
