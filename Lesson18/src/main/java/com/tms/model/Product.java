package com.tms.model;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class Product {
    private final String name;

    public Product(Integer id) {
        this.name = "Product " + id;
    }
}
