package com.home.heads;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ToshibaHead implements IHead {
    private int price;

    @Override
    public void speek() {
        System.out.println("Говорит голова Toshiba");
    }

    @Override
    public int getPrice() {
        return price;
    }
}
