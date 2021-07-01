package com.home.service;

import com.home.model.Computer;

public class Main {
    public static void main(String[] args) {
        Computer computer = new Computer("i7", 16, 2, 3);
        computer.on();
        computer.info();
        computer.off();
        computer.on();
        computer.info();
        computer.off();
        computer.on();
        computer.info();
        computer.off();
        computer.on();
        computer.info();
        computer.off();

    }
}
