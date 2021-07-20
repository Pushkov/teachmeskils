package com.home.hands;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class SonyHand implements IHand {
    private int price;

    @Override
    public void upHand() {
        System.out.println("Поднялась вверх рука Sony");
    }

    @Override
    public int getPrice() {
        return this.price;
    }
}
