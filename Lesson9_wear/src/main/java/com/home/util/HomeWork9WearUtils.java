package com.home.util;

import java.security.SecureRandom;

public class HomeWork9WearUtils {
    private static final SecureRandom RANDOM = new SecureRandom();

    public static <T extends Enum> T getRandomEnumItem(Class<T> clazz) {
        T[] enumConstatnts = clazz.getEnumConstants();
        int randomIndex = RANDOM.nextInt(enumConstatnts.length);
        return enumConstatnts[randomIndex];
    }

    public static <T extends Enum> T getOtherRandomItem(T item) {
        T resultItem;
        do {
            resultItem = (T) getRandomEnumItem(item.getClass());
            System.out.println("> " + resultItem);
        } while (resultItem == item);
        return resultItem;
    }

    public static boolean getRandomBoolean() {
        return RANDOM.nextBoolean();
    }

    public static int getRandomInt(int bound) {
        return RANDOM.nextInt(bound);
    }
}
