package com.home;

import com.home.interfaces.IHuman;
import com.home.model.*;
import com.home.service.HumanService;

import static com.home.enums.WearType.JACKET;

public class HomeWork9_handlers {
    public static void main(String[] args) {
        Human human = new Human("Vik");
        IHuman humanService = new HumanService(human);
        humanService.takeWear(new Hat());
        humanService.takeWear(new Jacket());
        humanService.takeWear(new Pants());
        humanService.takeWear(new Shoes());

        System.out.println("Вариант с последовательным вызовом");
        humanService.wearPutOn();
        humanService.wearTakeOff();
        System.out.println();
        humanService.dropWear(JACKET);
        humanService.wearPutOn();
        humanService.wearTakeOff();
        System.out.println();
        System.out.println("Вариант со списком");
        humanService.wearPutOnWears();
        System.out.println();
        humanService.wearTakeOffWears();

    }
}
