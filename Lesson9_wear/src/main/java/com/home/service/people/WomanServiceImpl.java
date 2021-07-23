package com.home.service.people;

import com.home.model.people.Woman;
import com.home.model.wear.IWear;
import com.home.model.wear.dress.IDress;
import com.home.model.wear.hat.IHat;
import com.home.model.wear.reticule.IReticule;
import com.home.model.wear.shoes.IShoes;
import lombok.AllArgsConstructor;

import static com.home.util.HomeWork9WearUtils.getRandomBoolean;

@AllArgsConstructor
public class WomanServiceImpl implements IWomanService {
    private final Woman woman;

    @Override
    public void takeItem(IWear item) {
        if (!isCaprice()) {
            switch (item.getWearType()) {
                case HAT:
                    this.woman.setHat((IHat) item);
                    System.out.println("Шляпка " + item.getClass().getSimpleName() + " цвета " + item.getColor() + " подошла");
                    break;
                case DRESS:
                    this.woman.setDress((IDress) item);
                    System.out.println("Платье " + item.getClass().getSimpleName() + " цвета " + item.getColor() + " подошло");
                    break;
                case RETICULE:
                    this.woman.setReticule((IReticule) item);
                    System.out.println("Сумочка " + item.getClass().getSimpleName() + " цвета " + item.getColor() + " подошла");
                    break;
                case SHOES:
                    this.woman.setShoes((IShoes) item);
                    System.out.println("Туфли " + item.getClass().getSimpleName() + " цвета " + item.getColor() + " подошли");
                    break;
            }
        } else {
            System.out.println("Вещь " + item.getClass().getSimpleName() + " цвета " + item.getColor() + " не понравилась");
        }
    }

    private boolean isCaprice() {
        return getRandomBoolean();
    }

    @Override
    public String dressingInfo() {
        return "Женщина " + this.woman.getName() + "\n- выбрала:\n" +
                (this.woman.getHat() != null ? " шляпку\n" : "") +
                (this.woman.getDress() != null ? " платье\n" : "") +
                (this.woman.getReticule() != null ? " сумочку\n" : "") +
                (this.woman.getShoes() != null ? " туфли \n" : "") +
                "- осталось выбрать:\n" +
                (this.woman.getHat() == null ? " шляпку\n" : "") +
                (this.woman.getDress() == null ? " платье\n" : "") +
                (this.woman.getReticule() == null ? " сумочку\n" : "") +
                (this.woman.getShoes() == null ? " туфли\n" : "");
    }

    @Override
    public boolean isWomanPleased() {
        return this.woman.getHat() != null &&
                this.woman.getDress() != null &&
                this.woman.getReticule() != null &&
                this.woman.getShoes() != null;
    }
}
