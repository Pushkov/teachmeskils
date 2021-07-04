package com.home.service;

import com.home.model.Computer;

public class Main {
    public static void main(String[] args) {

        ComputerService computerService = new ComputerServiceImpl();
        Computer computer = new Computer("i7", 16, 2, 3);
        for (int i = 0; i < 5; i++) {
            System.out.println();
            System.out.println(" ***** Попытка включения № " + (i + 1) + " *****");
            computerService.on(computer);
            computerService.info(computer);
            computerService.off(computer);
        }
    }
}
