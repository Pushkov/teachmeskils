package com.home.model;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

public class Shop {
    @Getter
    @Setter
    private boolean isWorking = true;
    private List<Product> products;

    public List<Product> getProducts() {
        if (products == null) {
            products = new ArrayList<>();
        }
        return products;
    }
}
