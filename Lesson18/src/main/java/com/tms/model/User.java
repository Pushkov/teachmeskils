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
    private CashRegister cass;

    public User(Integer id) {
        this.name = "User " + id;
    }

    @Override
    public void run() {
        if (cass == null) {
            userPay();
        } else {
            synchronized (cass) {
                userPay();
            }
        }
    }

    private void userPay() {
        String cashRegistersName = Thread.currentThread().getName();
        System.out.println(cashRegistersName + " обслуживает покупателя " + name + " :");
        for (Product product : products) {
            System.out.println(" - Оплата товара: " + product.getName() + " покупателем " + name + ", в " + cashRegistersName);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(cashRegistersName + " освободилась");
    }
}
