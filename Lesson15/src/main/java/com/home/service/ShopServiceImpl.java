package com.home.service;

import com.home.exception.GoodAlreadyExistException;
import com.home.model.Good;
import com.home.model.Shop;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

public class ShopServiceImpl implements ShopService {
    private final Shop shop;


    public ShopServiceImpl(Shop shop) {
        this.shop = shop;
    }

    @Override
    public List<Good> getAllGoods() {
        return shop.getGoods();
    }

    @Override
    public Good getGoodById(int id) {
        return findById(id)
                .orElseThrow(() -> new NoSuchElementException("Товар с ID = " + id + " не найден."));
    }

    @Override
    public void takeGood(Good good) throws GoodAlreadyExistException {
        if (!isGoodExists(good)) {
            shop.getGoods().add(good);
        } else {
            throw new GoodAlreadyExistException("Товар с ID = " + good.getId() + " уже есть в магазине.");
        }
    }

    @Override
    public void editGood(int id, Good good) throws GoodAlreadyExistException {
        if (!isGoodExists(good) || id == good.getId()) {
            Good sourceGood = findById(id)
                    .orElseThrow(() -> new NoSuchElementException("Товар с ID = " + id + " не найден."));
            List<Good> goods = shop.getGoods();
            int index = goods.indexOf(sourceGood);
            goods.set(index, good);
        } else {
            throw new GoodAlreadyExistException("Товар с ID = " + good.getId() + " уже есть в магазине.");
        }
    }

    @Override
    public void removeGood(int id) {
        Good good = findById(id)
                .orElseThrow(() -> new NoSuchElementException("Товар с ID = " + id + " не найден."));
        shop.getGoods().remove(good);
    }

    @Override
    public boolean isWorking() {
        return shop.isWorking();
    }

    @Override
    public void closeShop() {
        shop.setWorking(false);
    }

    private boolean isGoodExists(Good good) {
        return shop.getGoods().stream()
                .anyMatch(g -> g.getId() == good.getId());
    }

    private Optional<Good> findById(int id) {
        return shop.getGoods().stream()
                .filter(g -> g.getId() == id)
                .findAny();
    }
}
