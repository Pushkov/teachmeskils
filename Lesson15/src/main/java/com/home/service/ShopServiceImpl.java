package com.home.service;

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
                .orElseThrow(() -> new NoSuchElementException("No Good with id = " + id + " found !!!"));
    }

    @Override
    public void takeGood(Good good) {
        if (!isGoodExists(good)) {
            shop.getGoods().add(good);
        } else {
            throw new RuntimeException("такой товар есть");
        }
    }

    @Override
    public void editGood(Good good) {

    }

    @Override
    public void removeGood(int id) {
        Good good = findById(id)
                .orElseThrow(() -> new NoSuchElementException("No Good with id = " + id + " found !!!"));
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
