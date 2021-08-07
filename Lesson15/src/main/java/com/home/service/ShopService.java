package com.home.service;

import com.home.exception.GoodAlreadyExistException;
import com.home.model.Good;

import java.util.List;

public interface ShopService {
    List<Good> getAllGoods();

    Good getGoodById(int id);

    void takeGood(Good good) throws GoodAlreadyExistException;

    void editGood(int id, Good good) throws GoodAlreadyExistException;

    void removeGood(int id);

    boolean isWorking();

    void closeShop();
}
