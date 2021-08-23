package com.tms.model;

import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@ToString
public class CashRegister {
    private final String name;
    private List<User> queue = new ArrayList<>();

    public CashRegister(Integer id) {
        this.name = "Касса-" + id;
    }
}
