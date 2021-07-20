package com.home.legs;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class SamsungLeg implements ILeg {
    private final int price;

    @Override
    public void step() {
        System.out.println("Сделала шаг нога Samsung");
    }

    @Override
    public int getPrice() {
        return this.price;
    }
}
