package com.tms.produce;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Factory {
    int Id;

    private Factory() {
    }

    private static Factory instance;

    public static Factory getInstance() {
        if (instance == null) {
            instance = new Factory();
        }
        return instance;
    }

    public <T extends Object> List<T> create(Class<T> clazz, int limit) {
        Id = 1;
        return Stream.generate(() -> {
            try {
                return clazz.getDeclaredConstructor(Integer.class).newInstance(getId());
            } catch (InstantiationException | InvocationTargetException | IllegalAccessException | NoSuchMethodException e) {
                e.printStackTrace();
            }
            return null;
        })
                .limit(limit)
                .collect(Collectors.toList());
    }

    private int getId() {
        return Id++;
    }

}
