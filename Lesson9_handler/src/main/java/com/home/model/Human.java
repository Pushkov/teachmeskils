package com.home.model;

import com.home.interfaces.IWear;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Human {
    private final String name;
    private Jacket jacket;
    private Hat hat;
    private Pants pants;
    private Shoes shoes;
    List<IWear> wearList = new ArrayList<>();

    public Human(String name) {
        this.name = name;
    }
}
