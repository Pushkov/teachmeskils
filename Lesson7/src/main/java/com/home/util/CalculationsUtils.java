package com.home.util;

import java.util.Scanner;

public class CalculationsUtils {

    public static double powerToKW(double powerInHorsePower) {
        return powerInHorsePower * 0.74;
    }

    public static double readDataFromConsole(String message) {
        Scanner scanner = new Scanner(System.in);
        double number;
        boolean isPositiveNumber = true;
        do {
            System.out.println(message + ":");
            while (!scanner.hasNextDouble()) {
                System.out.println("Введенное не является числом.");
                scanner.next();
            }
            number = scanner.nextDouble();
            isPositiveNumber = checkNumberIsNonPositive(number);
        } while (isPositiveNumber);
        return number;
    }

    private static boolean checkNumberIsNonPositive(double number) {
        boolean isPositiveNumber = true;
        if (number > 0) {
            isPositiveNumber = false;
        } else {
            System.out.println("Введенное не является ПОЛОЖИТЕЛЬНЫМ числом.");
        }
        return isPositiveNumber;
    }
}
