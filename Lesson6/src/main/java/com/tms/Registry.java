package com.tms;

import lombok.Getter;
import lombok.Setter;

import static com.home.constant.Constants.MAX_AGE;
import static com.home.constant.Constants.MIN_AGE;

@Getter
@Setter
public class Registry {
    private Person[] persons;

    public void getAllSuitablePersons() {
        for (Person p : this.persons) {
            if (p.getAge() >= MIN_AGE && p.getAge() < MAX_AGE) {
                System.out.println(p);
            }
        }
    }

    public void getPersonFromCity(String city) {
        for (Person p : this.persons) {
            if (p.getAddress().getCity().equals(city) && p.getAge() >= MIN_AGE && p.getAge() < MAX_AGE) {
                System.out.println(p);
            }
        }
    }
}
