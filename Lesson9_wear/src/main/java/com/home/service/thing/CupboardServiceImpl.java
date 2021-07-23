package com.home.service.thing;

import com.home.enums.WearType;
import com.home.model.thing.Cupboard;
import com.home.model.wear.IWear;

import java.util.List;
import java.util.stream.Collectors;

import static com.home.util.HomeWork9WearUtils.getRandomInt;

public class CupboardServiceImpl implements ICupboardService {
    private final Cupboard cupboard;

    public CupboardServiceImpl(Cupboard cupboard) {
        this.cupboard = cupboard;
    }

    @Override
    public int getWearsCountInCupboard() {
        return this.cupboard.getWears().size();
    }

    @Override
    public void addOneItem(IWear item) {
        this.cupboard.getWears().add(item);
    }

    @Override
    public void addPackItems(List<IWear> items) {
        this.cupboard.getWears().addAll(items);
    }

    @Override
    public IWear getItem() {
        IWear resultWear = null;
        List<IWear> wears = this.cupboard.getWears();
        if (wears.size() > 0) {
            resultWear = getRandomWear(wears);
            this.cupboard.getWears().remove(resultWear);
        }
        return resultWear;
    }

    @Override
    public IWear findItemByWearType(WearType type) {
        IWear resultWear = null;
        List<IWear> wears = this.cupboard.getWears()
                .stream()
                .filter(item -> item.getWearType() == type)
                .collect(Collectors.toList());
        if (wears.size() > 0) {
            resultWear = getRandomWear(wears);
            this.cupboard.getWears().remove(resultWear);
        }
        return resultWear;
    }

    private IWear getRandomWear(List<IWear> wears) {
        int index = getRandomInt(wears.size());
        return wears.get(index);
    }
}
