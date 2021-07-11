package com.home.util;

import java.util.Scanner;

public class CalculationsUtils {

    public static Integer powerToKW(Integer powerInHorsePower) {
        return (int) Math.round(powerInHorsePower * 0.74);
    }

    public static Integer powerToHP(Integer powerInKiloWatt) {
        return (int) Math.round(powerInKiloWatt / 0.74);
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
            isPositiveNumber = checkNumberIsPositive(number);
        } while (isPositiveNumber);
        return number;
    }

    private static boolean checkNumberIsPositive(double number) {
        boolean isPositiveNumber = true;
        if (number > 0) {
            isPositiveNumber = false;
        } else {
            System.out.println("Введенное не является ПОЛОЖИТЕЛЬНЫМ числом.");
        }
        return isPositiveNumber;
    }
}
