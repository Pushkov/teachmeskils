package com.home.model.thing;

import com.home.model.wear.IWear;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Cupboard implements ICupboard {
    private List<IWear> wears = new ArrayList<>();
}
