package com.home.heads;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class SamsungHead implements IHead {
    private int price;

    @Override
    public void speek() {
        System.out.println("Говорит голова Samsung");
    }

    @Override
    public int getPrice() {
        return price;
    }
}
