package com.home.service;

import java.util.Scanner;

public class InputUtils {

    public static int readStartupCode() {
        Scanner scanner = new Scanner(System.in);
        boolean isCodeCorrect = false;
        int startCode = -1;
        System.out.println("Введите 0 или 1: ");
        do {
            while (!scanner.hasNextInt()) {
                System.out.println("Проверьте введенные данные!");
                scanner.next();
            }
            startCode = scanner.nextInt();
            if (startCode == 1 || startCode == 0) {
                isCodeCorrect = true;
            } else {
                System.out.println("Проверьте введенные данные!");
            }
        } while (!isCodeCorrect);
        return startCode;
    }

}
