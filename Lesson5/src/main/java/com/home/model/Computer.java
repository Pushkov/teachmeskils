package com.home.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Scanner;

@AllArgsConstructor
@Getter
@Setter
@ToString
public class Computer {

    private String processor;
    private Integer quantityRAM;
    private Integer quantityHDD;
    private Integer resource;

    public void on() {
        Scanner scanner = new Scanner(System.in);
        int startCode = -1;
        do {
            System.out.println("Введите 0 или 1: ");
            while (scanner.hasNextInt()) {
                System.out.println("Проверьте введенные данные!");
                scanner.next();
            }
            startCode = scanner.nextInt();

        } while (startCode != 1 || startCode != 0);
        System.out.println("Компьютер запущен");
        scanner.close();
    }
}
