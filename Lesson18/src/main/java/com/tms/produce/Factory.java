package com.tms.produce;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Factory {
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
        AtomicInteger id = new AtomicInteger(0);
        return Stream.generate(() -> createObjectByClass(clazz, id))
                .limit(limit)
                .collect(Collectors.toList());
    }

    private <T> T createObjectByClass(Class<T> clazz, AtomicInteger id) {
        try {
            return clazz.getDeclaredConstructor(Integer.class).newInstance(id.incrementAndGet());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
