package com.home;

import com.home.model.Good;
import com.home.model.Shop;
import com.home.service.ShopService;
import com.home.service.ShopServiceImpl;
import com.home.service.ShopUIService;
import com.home.util.InputUtils;

import java.util.List;

public class HomeWork15 {
    private static ShopService shopService;

    public static void main(String[] args) {
        Shop shop = new Shop();
        shopService = new ShopServiceImpl(shop);
        ShopUIService ui = new ShopUIService(shopService);
        init();
        while (shopService.isWorking()) {
            ui.startPage();
            InputUtils.waitEnterKey();
        }
        System.out.println("Магазин закрыт!!!");
    }

    private static void init() {
        List<Good> list = List.of(
                Good.builder().id(1).name("Хлеб").price(10).build(),
                Good.builder().id(2).name("Масло").price(20).build(),
                Good.builder().id(3).name("Молоко").price(15).build(),
                Good.builder().id(4).name("Творог").price(30).build(),
                Good.builder().id(5).name("Торт").price(60).build()
        );
        for (Good good : list) {
            shopService.takeGood(good);
        }
    }
}
