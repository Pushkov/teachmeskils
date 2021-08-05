package com.home.service;

import com.home.model.Good;
import com.home.util.GoodComparatorById;
import com.home.util.GoodComparatorByName;
import com.home.util.GoodComparatorByPrice;

import java.util.List;
import java.util.stream.Collectors;

import static com.home.util.DrawUI.*;
import static com.home.util.InputUtils.readDataFromConsole;

public class ShopUIService {
    private final ShopService service;

    public ShopUIService(ShopService service) {
        this.service = service;
    }

    public void startPage() {
        drawStartMenu();
        int bound = 5;
        int menuPoint = readDataFromConsole("Введите число от 1 до " + bound, bound);
        switch (menuPoint) {
            case 1:
                sortingPage();
                break;
            case 2:
                addGoodPage();
                break;
            case 3:
                System.out.println(sortListByPrice(service.getAllGoods()));
                break;
            case 4:
                break;
            case 5:
                service.closeShop();
                break;
        }
    }

    public void sortingPage() {
        drawSortingGoodsMenu();
        int bound = 4;
        int menuPoint = readDataFromConsole("Введите число от 1 до " + bound, bound);
        switch (menuPoint) {
            case 1:
                System.out.println(sortListById(service.getAllGoods()));
                break;
            case 2:
                System.out.println(sortListByName(service.getAllGoods()));
                break;
            case 3:
                System.out.println(sortListByPrice(service.getAllGoods()));
                break;
            case 4:
                startPage();
                break;
        }
    }

    public void addGoodPage() {
        drawAddGoodMenu();
        int id = readDataFromConsole("Задайте Id товара", Integer.MAX_VALUE);
        int name = readDataFromConsole("Задайте наименование товара", Integer.MAX_VALUE);
        int price = readDataFromConsole("Задайте цену товара", Integer.MAX_VALUE);
        service.takeGood(Good.builder()
                .id(id)
                .name(String.valueOf(name))
                .price(price)
                .build());
        startPage();
    }


    private List<Good> sortListByName(List<Good> list) {
        return list.stream().sorted(new GoodComparatorByName()).collect(Collectors.toList());
    }

    private List<Good> sortListById(List<Good> list) {
        return list.stream().sorted(new GoodComparatorById()).collect(Collectors.toList());
    }

    private List<Good> sortListByPrice(List<Good> list) {
        return list.stream().sorted(new GoodComparatorByPrice()).collect(Collectors.toList());
    }
}
