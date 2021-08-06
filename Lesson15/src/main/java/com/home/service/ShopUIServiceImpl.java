package com.home.service;

import com.home.exception.GoodAlreadyExistException;
import com.home.form.GoodForm;
import com.home.model.Good;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import static com.home.form.GoodForm.fromGood;
import static com.home.form.GoodForm.toGood;
import static com.home.util.DrawUI.*;
import static com.home.util.InputUtils.readIntFromConsole;
import static com.home.util.InputUtils.readStringFromConsole;
import static java.util.Collections.reverse;
import static java.util.Comparator.comparing;

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
        int bound = 6;
        int menuPoint = readIntFromConsole("Введите число от 1 до " + bound, bound);
        List<Good> allGoods = service.getAllGoods();
        switch (menuPoint) {
            case 1:
                printGoodsList(sortListById(allGoods), "ID");
                break;
            case 2:
                printGoodsList(sortListByName(allGoods), "Наименование");
                break;
            case 3:
                printGoodsList(sortListByPriceAsс(allGoods), "Цена по-возрастанию");
                break;
            case 4:
                printGoodsList(sortListByPriceDesс(allGoods), "Цена по-убыванию");
                break;
            case 5:
                printGoodsList(sortListByAdd(allGoods), "По порядку добавления");
                break;
            case 6:
                startPage();
                break;
        }
    }

    private void addGoodPage() {
        drawAddGoodMenu();
        try {
            GoodForm form = createGoodForm();
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
            GoodForm form = createGoodForm();
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

    private GoodForm createGoodForm() {
        return GoodForm.builder()
                .id(readIntFromConsole("Задайте Id товара", Integer.MAX_VALUE))
                .name(readStringFromConsole("Задайте наименование товара"))
                .price(readIntFromConsole("Задайте цену товара", Integer.MAX_VALUE))
                .build();
    }

    private List<Good> sortListByName(List<Good> list) {
        return list.stream().sorted(comparing(a -> a.getName().toUpperCase())).collect(Collectors.toList());
    }

    private List<Good> sortListById(List<Good> list) {
        return list.stream().sorted(comparing(Good::getId)).collect(Collectors.toList());
    }

    private List<Good> sortListByPriceAsс(List<Good> list) {
        return list.stream().sorted(comparing(Good::getPrice)).collect(Collectors.toList());
    }

    private List<Good> sortListByPriceDesс(List<Good> list) {
        return list.stream().sorted(comparing(Good::getPrice).reversed()).collect(Collectors.toList());
    }

    private List<Good> sortListByAdd(List<Good> list) {
        List<Good> reverseList = new ArrayList<>(list);
        reverse(reverseList);
        return reverseList;
    }

    private void printGoodsList(List<Good> goodList, String sortBy) {
        System.out.printf("***** Список товара в магазине (сортировано по полю: %s).\n", sortBy);
        goodList.forEach(System.out::println);
    }
}
