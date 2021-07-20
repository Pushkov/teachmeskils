package com.home.util;

import java.util.Scanner;

public class CalculationsUtils {

    public static double powerToKW(double powerInHorsePower) {
        return powerInHorsePower * 0.74;
    }

    public static double readDataFromConsole(String message) {
        Scanner scanner = new Scanner(System.in);
        double number;
        do {
            System.out.println(message + ":");
            while (!scanner.hasNextDouble()) {
                System.out.println("Введенное не является числом.");
                scanner.next();
            }
            number = scanner.nextDouble();
        } while (isNonPositiveNumber(number));
        return number;
    }

    private static boolean isNonPositiveNumber(double number) {
        if (number < 0) {
            System.out.println("Введенное не является ПОЛОЖИТЕЛЬНЫМ числом.");
        }
        return number <= 0;
    }
}
