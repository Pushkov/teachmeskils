package com.home.service;

import com.home.model.Good;

import java.util.List;

public interface ShopService {
    List<Good> getAllGoods();

    Good getGoodById(int id);

    void takeGood(Good good);

    void editGood(Good good);

    void removeGood(int id);

    boolean isWorking();

    void closeShop();
}
