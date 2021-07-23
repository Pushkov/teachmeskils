package com.home.util;

import java.security.SecureRandom;

public class HomeWork9WearUtils {
    private static final SecureRandom RANDOM = new SecureRandom();

    public static <T extends Enum> T getRandomEnumItem(Class<T> clazz) {
        if (clazz != null) {
            T[] enumConstatnts = clazz.getEnumConstants();
            int randomIndex = RANDOM.nextInt(enumConstatnts.length);
            return enumConstatnts[randomIndex];
        } else {
            return null;
        }
    }

    public static <T extends Enum> T getOtherRandomItem(T item) {
        if (item != null) {
            T resultItem;
            do {
                resultItem = (T) getRandomEnumItem(item.getClass());
//                System.out.println("> " + resultItem);
            } while (resultItem == item);
            return resultItem;
        } else {
            return null;
        }
    }

    public static boolean getRandomBoolean() {
        return RANDOM.nextBoolean();
    }

    public static int getRandomInt(int bound) {
        return RANDOM.nextInt(bound);
    }
}
