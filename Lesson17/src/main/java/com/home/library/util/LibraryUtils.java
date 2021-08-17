package com.home.library.util;

import lombok.experimental.UtilityClass;

import java.util.Map;
import java.util.Set;

@UtilityClass
public class LibraryUtils {

    public static void printMap(Map<String, Long> map) {
        Set<String> keys = map.keySet();
        keys.forEach(k ->
                System.out.printf("%s - %d сотрудник%s\n", k, map.get(k), getEnding(map.get(k))));
    }

    private static String getEnding(long count) {
        long var1 = count % 10;
        long var2 = count % 100;
        String var3 = "";
        if (var1 >= 2) {
            var3 = "а";
        }
        if (var1 >= 5 || var1 == 0 || var2 >= 11 & var2 <= 14) {
            var3 = "ов";
        }
        return var3;
    }
}
