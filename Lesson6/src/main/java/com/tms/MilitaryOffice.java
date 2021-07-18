package com.tms;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MilitaryOffice {
    private Registry registry;

    public void getSuitablePersons() {
        this.registry.getAllSuitablePersons();
    }
}
