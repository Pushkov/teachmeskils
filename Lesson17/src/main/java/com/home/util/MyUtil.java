package com.home.util;

import java.util.ArrayList;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MyUtil {

    private static final Random random = new Random();

    public static ArrayList<Integer> getIntegerList(int count, int bound) {
        return (ArrayList<Integer>) Stream
                .generate(() -> random.nextInt(bound))
                .limit(count)
                .collect(Collectors.toList());
    }

    public static void printIntegerListPoint(Integer integer) {
        System.out.printf("%d ", integer);
    }

    public static void printStringListPoint(String string) {
        System.out.printf("%s ", string);
    }

    public static Set<Integer> getSet() {
        return Stream
                .generate(() -> random.nextInt(101))
                .distinct()
                .limit(10)
                .collect(Collectors.toSet());
    }
}
