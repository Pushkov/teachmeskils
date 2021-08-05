package com.home.util;

public class DrawUI {

    public static void drawStartMenu() {
        System.out.println("************************************************************");
        System.out.println("*              ДОБРО ПОЖАЛОВАТЬ В НАШ МАГАЗИН              *");
        System.out.println("*                                                          *");
        System.out.println("*              выберите один из пунктов меню               *");
        System.out.println("************************************************************");
        System.out.println("1 - Получить список всех товаров");
        System.out.println("2 - Добавить новый товар");
        System.out.println("3 - Редактировать существующий товар");
        System.out.println("4 - Удалить товар");
        System.out.println("5 - Закрыть магазин");

    }

    public static void drawSortingGoodsMenu() {
        System.out.println("************************************************************");
        System.out.println("*              Выберите параметр сортировки                *");
        System.out.println("************************************************************");
        System.out.println("1 - Id");
        System.out.println("2 - Наименование");
        System.out.println("3 - Цена");
        System.out.println("4 - Назад, в главное меню");
    }

    public static void drawAddGoodMenu() {
        System.out.println("************************************************************");
        System.out.println("*             Задайте параметры нового товара              *");
        System.out.println("************************************************************");
    }


}
