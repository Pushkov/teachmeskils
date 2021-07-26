package com.home.service;

import com.home.enums.WearType;
import com.home.interfaces.IHuman;
import com.home.interfaces.IWear;
import com.home.model.*;

public class HumanService implements IHuman {
    private final Human human;

    public HumanService(Human human) {
        this.human = human;
    }

    @Override
    public void takeWear(IWear item) {
        switch (item.getType()) {
            case HUT:
                this.human.setHat((Hat) item);
                break;
            case JACKET:
                this.human.setJacket((Jacket) item);
                break;
            case PANTS:
                this.human.setPants((Pants) item);
                break;
            case SHOES:
                this.human.setShoes((Shoes) item);
                break;
        }
        this.human.getWearList().add(item);
    }

    @Override
    public void dropWear(WearType type) {
        IWear wear = null;
        switch (type) {
            case HUT:
                wear = this.human.getHat();
                this.human.setHat(null);
                break;
            case JACKET:
                wear = this.human.getJacket();
                this.human.setJacket(null);
                break;
            case PANTS:
                wear = this.human.getPants();
                this.human.setPants(null);
                break;
            case SHOES:
                wear = this.human.getPants();
                this.human.setShoes(null);
                break;
        }
        this.human.getWearList().remove(wear);
    }

    public void wearPutOn() {
        if (this.human.getHat() != null) {
            this.human.getHat().putOn();
        } else {
            System.out.println("Шапки нет");
        }
        if (this.human.getJacket() != null) {
            this.human.getJacket().putOn();
        } else {
            System.out.println("Куртки нет");
        }
        if (this.human.getPants() != null) {
            this.human.getPants().putOn();
        } else {
            System.out.println("Брюк нет");
        }
        if (this.human.getShoes() != null) {
            this.human.getShoes().putOn();
        } else {
            System.out.println("Ботинок нет");
        }
    }

    public void wearTakeOff() {
        if (this.human.getHat() != null) {
            this.human.getHat().takeOff();
        } else {
            System.out.println("Шапки нет");
        }
        if (this.human.getJacket() != null) {
            this.human.getJacket().takeOff();
        } else {
            System.out.println("Куртки нет");
        }
        if (this.human.getPants() != null) {
            this.human.getPants().takeOff();
        } else {
            System.out.println("Брюк нет");
        }
        if (this.human.getShoes() != null) {
            this.human.getShoes().takeOff();
        } else {
            System.out.println("Ботинок нет");
        }
    }

    @Override
    public void wearPutOnWears() {
        for (IWear iwear : this.human.getWearList()) {
            iwear.putOn();
        }
    }

    @Override
    public void wearTakeOffWears() {
        for (IWear iwear : this.human.getWearList()) {
            iwear.takeOff();
        }
    }
}
