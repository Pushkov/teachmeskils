package com.home.model.people;

import com.home.model.wear.dress.IDress;
import com.home.model.wear.hat.IHat;
import com.home.model.wear.reticule.IReticule;
import com.home.model.wear.shoes.IShoes;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Woman {
    private final String name;
    private IHat hat;
    private IDress dress;
    private IReticule reticule;
    private IShoes shoes;

    public Woman(String name) {
        this.name = name;
    }
}
