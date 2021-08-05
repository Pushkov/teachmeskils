package com.home.service;

import com.home.exception.GoodAlreadyExistException;
import com.home.form.GoodForm;
import com.home.model.Good;
import lombok.extern.slf4j.Slf4j;

import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import static com.home.form.GoodForm.fromGood;
import static com.home.form.GoodForm.toGood;
import static com.home.util.DrawUI.*;
import static com.home.util.InputUtils.readIntFromConsole;
import static com.home.util.InputUtils.readStringFromConsole;

@Slf4j
public class ShopUIServiceImpl implements ShopUIService {
    private final ShopService service;

    public ShopUIServiceImpl(ShopService service) {
        this.service = service;
    }

    @Override
    public void openShop() {
        startPage();
    }

    private void startPage() {
        drawStartMenu();
        int bound = 5;
        int menuPoint = readIntFromConsole("Введите число от 1 до " + bound, bound);
        switch (menuPoint) {
            case 1:
                sortingPage();
                break;
            case 2:
                addGoodPage();
                break;
            case 3:
                editGoodPage();
                break;
            case 4:
                deleteGoodPage();
                break;
            case 5:
                service.closeShop();
                break;
        }
    }

    private void sortingPage() {
        drawSortingGoodsMenu();
        int bound = 4;
        int menuPoint = readIntFromConsole("Введите число от 1 до " + bound, bound);
        switch (menuPoint) {
            case 1:
                printGoodsList(sortListById(service.getAllGoods()));
                break;
            case 2:
                printGoodsList(sortListByName(service.getAllGoods()));
                break;
            case 3:
                printGoodsList(sortListByPrice(service.getAllGoods()));
                break;
            case 4:
                startPage();
                break;
        }
    }

    private void addGoodPage() {
        drawAddGoodMenu();
        GoodForm form = GoodForm.builder()
                .id(readIntFromConsole("Задайте Id товара", Integer.MAX_VALUE))
                .name(readStringFromConsole("Задайте наименование товара"))
                .price(readIntFromConsole("Задайте цену товара", Integer.MAX_VALUE))
                .build();
        try {
            service.takeGood(toGood(form));
            System.out.println("*** Товар добавлен");
        } catch (GoodAlreadyExistException e) {
            System.out.println(e.getMessage());
//            log.error(e.getMessage());
            startPage();
        }
    }

    private void editGoodPage() {
        drawSelectIdGoodMenu();
        int selectId = readIntFromConsole("Введите Id товара", Integer.MAX_VALUE);
        try {
            Good good = service.getGoodById(selectId);
            drawEditGoodMenu(fromGood(good));
            GoodForm form = GoodForm.builder()
                    .id(readIntFromConsole("Задайте Id товара", Integer.MAX_VALUE))
                    .name(readStringFromConsole("Задайте наименование товара"))
                    .price(readIntFromConsole("Задайте цену товара", Integer.MAX_VALUE))
                    .build();
            service.editGood(good.getId(), toGood(form));
            System.out.println("*** Товар изменен");
        } catch (NoSuchElementException | GoodAlreadyExistException e) {
            System.out.println(e.getMessage());
//            log.error(e.getMessage());
            startPage();
        }
    }

    private void deleteGoodPage() {
        drawSelectIdGoodMenu();
        int selectId = readIntFromConsole("Введите Id товара", Integer.MAX_VALUE);
        try {
            Good good = service.getGoodById(selectId);
            drawDeleteGoodMenu(fromGood(good));
            int bound = 2;
            int menuPoint = readIntFromConsole("Введите число от 1 до " + bound, bound);
            switch (menuPoint) {
                case 1:
                    service.removeGood(good.getId());
                    System.out.println("*** Товар удален");
                    break;
                case 2:
                    startPage();
                    break;
            }
        } catch (NoSuchElementException e) {
            System.out.println(e.getMessage());
//            log.error(e.getMessage());
            startPage();
        }
    }

    private List<Good> sortListByName(List<Good> list) {
        return list.stream().sorted(Comparator.comparing(a -> a.getName().toUpperCase())).collect(Collectors.toList());
    }

    private List<Good> sortListById(List<Good> list) {
        return list.stream().sorted(Comparator.comparing(Good::getId)).collect(Collectors.toList());
    }

    private List<Good> sortListByPrice(List<Good> list) {
        return list.stream().sorted(Comparator.comparing(Good::getPrice)).collect(Collectors.toList());
    }

    private void printGoodsList(List<Good> goodList) {
        System.out.println("***** Список товара в магазине");
        for (Good good : goodList) {
            System.out.println(good);
        }
    }
}
