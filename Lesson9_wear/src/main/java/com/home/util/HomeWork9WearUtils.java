package com.home.util;

import java.security.SecureRandom;

public class HomeWork9WearUtils {
    private static final SecureRandom RANDOM = new SecureRandom();

    public static <T extends Enum> T getRandomEnumItem(Class<T> clazz) {
        int randomIndex = RANDOM.nextInt(clazz.getEnumConstants().length);
        return clazz.getEnumConstants()[randomIndex];
    }

//    public static <T extends Enum> T getOtherRandomItem(T item) {
//        T resultItem;
//        do {
//            resultItem = getRandomEnumItem( item.getClass().);
//            System.out.println("> " + resultItem);
//        } while (resultItem == item);
//        return resultItem;
//    }

    public static boolean getRandomBoolean() {
        return RANDOM.nextBoolean();
    }

    public static int getRandomInt(int bound) {
        return RANDOM.nextInt(bound);
    }
}
