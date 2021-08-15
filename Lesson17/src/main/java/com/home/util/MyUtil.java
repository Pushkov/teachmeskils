package com.home.util;

import com.home.model.Person;

import java.util.*;
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

    public static void printCollection(Collection<?> list) {
        list.forEach(MyUtil::printWord);
    }

    public static void printWord(Object word) {
        System.out.print(word.toString() + " ");
    }

    public static Set<Integer> getSet() {
        return Stream
                .generate(() -> random.nextInt(101))
                .distinct()
                .limit(10)
                .collect(Collectors.toSet());
    }

    public static List<Person> getPersonsList() {
        return List.of(
                new Person("Иван", "Иванов"),
                new Person("Данила", "Данилов"),
                new Person("Александр", "Александров"),
                new Person("Сергей", "Сергеев"),
                new Person("Дмитрий", "Дмитриев"),
                new Person("Андрей", "Андреев"),
                new Person("Антон", "Антонов")
        );
    }

}
