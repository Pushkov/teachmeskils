package com.home.hands;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ToshibaHand implements IHand {
    private int price;

    @Override
    public void upHand() {
        System.out.println("Поднялась вверх рука Toshiba");
    }

    @Override
    public int getPrice() {
        return this.price;
    }
}
