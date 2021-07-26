package com.home;

import com.home.interfaces.IHuman;
import com.home.interfaces.IWear;
import com.home.model.*;
import com.home.service.HumanService;

import java.util.List;

import static com.home.enums.WearType.JACKET;

public class HomeWork9_handlers {
    public static void main(String[] args) {
        Human human = new Human("Vik");
        IHuman humanService = new HumanService(human);
        for (IWear wear : getIWearList()) {
            humanService.takeWear(wear);
        }

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

    private static List<IWear> getIWearList() {
        return List.of(
                new Hat(),
                new Jacket(),
                new Pants(),
                new Shoes());
    }
}
