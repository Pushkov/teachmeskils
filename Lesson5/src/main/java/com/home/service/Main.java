package com.home.service;

import com.home.model.Computer;

public class Main {
    public static void main(String[] args) {

        ComputerService computerService = new ComputerServiceImpl();
        Computer computer = new Computer("i7", 16, 2, 3);
        Computer computer1 = new Computer("i3", 8, 1, 2);
        Computer computer2 = new Computer("i5", 32, 5, 4);
        for (int i = 0; i < 5; i++) {
            System.out.println();
            System.out.println(" ***** Попытка включения № " + (i + 1) + " *****");
            computerService.on(computer);
            computerService.info(computer);
            computerService.on(computer1);
            computerService.off(computer);
            computerService.on(computer2);
            computerService.info(computer1);
            computerService.off(computer1);
            computerService.info(computer2);
            computerService.off(computer2);
        }
    }
}
