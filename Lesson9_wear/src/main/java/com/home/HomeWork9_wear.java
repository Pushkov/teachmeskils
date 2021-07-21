package com.home;

import com.home.model.people.Woman;
import com.home.model.thing.Cupboard;
import com.home.model.wear.IWear;
import com.home.model.wear.dress.EveningDress;
import com.home.model.wear.dress.SimpleDress;
import com.home.model.wear.hat.KepiHat;
import com.home.model.wear.hat.PanamaHat;
import com.home.model.wear.reticule.OfficeReticule;
import com.home.model.wear.reticule.ShoppingReticule;
import com.home.model.wear.reticule.SmallReticule;
import com.home.model.wear.shoes.ComfortableShoes;
import com.home.model.wear.shoes.DancingShoes;
import com.home.model.wear.shoes.HighNeedledShoes;
import com.home.service.people.IWomanService;
import com.home.service.people.WomanServiceImpl;
import com.home.service.thing.CupboardServiceImpl;
import com.home.service.thing.ICupboardService;
import com.home.util.HomeWork9WearUtils;

import java.util.List;

import static com.home.enums.WearColors.*;
import static com.home.util.HomeWork9WearUtils.getOtherRandomItem;

public class HomeWork9_wear {

    public static void main(String[] args) {
        System.out.println("***************");
        for (int i = 0; i < 8 ; i++) {
            getOtherRandomItem(RED);
        }
        System.out.println("***************");


        Cupboard cupboard = new Cupboard();
        ICupboardService cupboardService = new CupboardServiceImpl(cupboard);

        cupboardService.addPackItems(getHatList());
        cupboardService.addPackItems(getDressList());
        cupboardService.addPackItems(getReticulesList());
        cupboardService.addPackItems(getShoesList());

        Woman woman = new Woman("Toma");
        IWomanService womanService = new WomanServiceImpl(woman);
        int count = 0;
        while (!womanService.isWomanPleased() && cupboardService.getWearsCountInCupboard() > 0) {
            womanService.takeItem(cupboardService.getItem());
            System.out.println(womanService.dressingInfo());
            count++;
        }
        if (womanService.isWomanPleased()) {
            System.out.println("Женщина " + woman.getName() + " оделась за " + count + " минут.");
            System.out.println("В шкау осталось " + cupboardService.getWearsCountInCupboard() + " вещей.");
        } else {
            System.out.println("В шкафу закончились вещи");
        }
    }

    private static List<IWear> getHatList() {
        return List.of(
                new KepiHat(RED),
                new KepiHat(BLUE),
                new PanamaHat(BLUE),
                new PanamaHat(YELLOW),
                new PanamaHat(GREEN)
        );
    }

    private static List<IWear> getDressList() {
        return List.of(
                new SimpleDress(RED),
                new SimpleDress(YELLOW),
                new EveningDress(GREEN)
        );
    }

    private static List<IWear> getReticulesList() {
        return List.of(
                new ShoppingReticule(RED),
                new ShoppingReticule(BLUE),
                new OfficeReticule(YELLOW),
                new OfficeReticule(GREEN),
                new SmallReticule(BLUE)
        );
    }

    private static List<IWear> getShoesList() {
        return List.of(
                new DancingShoes(GREEN),
                new HighNeedledShoes(GREEN),
                new HighNeedledShoes(RED),
                new ComfortableShoes(YELLOW),
                new ComfortableShoes(BLUE)
        );
    }
}
