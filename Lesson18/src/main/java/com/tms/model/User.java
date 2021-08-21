package com.tms.model;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class User implements Runnable {
    private final String name;
    private List<Product> products;

    public User(Integer id) {
        this.name = "User " + id;
    }

    @Override
    public void run() {
        String cashRegistersName = Thread.currentThread().getName();
        System.out.println("Касса" + cashRegistersName + " обслуживает покупателя " + name + " :");
        for (Product product : products) {
            System.out.println(" - Оплата товара: " + product.getName() + " в кассе " + cashRegistersName);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println(" error");
                e.printStackTrace();
            }
        }
        System.out.println("Касса " + cashRegistersName + " освободилась");
    }
}
