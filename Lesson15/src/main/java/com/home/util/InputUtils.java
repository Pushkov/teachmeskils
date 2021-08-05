package com.home.util;

import java.util.Scanner;

public class InputUtils {

    public static int readDataFromConsole(String message, int bound) {
        Scanner scanner = new Scanner(System.in);
        int number;
        do {
            System.out.println(message + ":");
            while (!scanner.hasNextDouble()) {
                System.out.println("Введенное не является числом.");
                scanner.next();
            }
            number = scanner.nextInt();
        } while (isNotInBounds(number, bound));
        return number;
    }

    private static boolean isNotInBounds(int number, int bound) {
        if (number < 1 || number > bound) {
            System.out.println("Введенное не связано с пунктами меню.");
        }
        return number < 1 || number > bound;
    }

    public static String waitEnterKey() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("*** Нажмите ENTER клавишу для продолжения ***");
        scanner.nextLine();
        return "";
    }

}
