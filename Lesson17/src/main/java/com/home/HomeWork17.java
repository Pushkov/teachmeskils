package com.home;

import com.home.model.Car;
import com.home.util.MyUtil;
import org.apache.commons.lang3.StringUtils;

import java.util.*;

import static com.home.util.MyUtil.*;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

public class HomeWork17 {
    public static void main(String[] args) {
//        point1();
//        point2();
//        point3();
//        point4();
        point5_1();
//        point5_2();
    }

    private static void point1() {
        ArrayList<Integer> list = getIntegerList(10, 30);
        printCollection(list);
        System.out.println();
        list.stream()
                .map(number -> number * 2)
                .forEach(MyUtil::printWord);
    }

    private static void point2() {
        Set<Integer> set = getSet();
        printCollection(set);
        System.out.println("\n" + set.size());
        int count = (int) set.stream()
                .filter(integer -> integer % 2 == 0)
                .count();
        System.out.println(count);
    }

    private static void point3() {
        List<String> listNames = List.of("john", "arya", "sansa");
        listNames.stream()
                .map(StringUtils::capitalize)
                .forEach(MyUtil::printWord);

    }

    private static void point4() {
        List<Car> cars = List.of(
                new Car("AA1111BX", 2007),
                new Car("AK5555IT", 2010),
                new Car(null, 2012),
                new Car("", 2015),
                new Car("AI3838PP", 2017));
        cars.stream()
                .filter(car -> car.getYear() >= 2010)
                .map(Car::getNumber)
                .filter(Objects::nonNull)
                .filter(x -> !x.equals(""))
                .forEach(System.out::println);
    }


    private static void point5_1() {
        var list = getPersonsList();
        list.stream()
                .filter(person -> person.getLastName().startsWith("К"))
                .forEach(System.out::println);
    }

    private static void point5_2() {
        var list = getPersonsList();
        Map<String, Long> personsByFirstLetterInLastName = list.stream()
                .collect(groupingBy(person -> person.getLastName().substring(0, 1), counting()));
        print(personsByFirstLetterInLastName);
    }

    public static void print(Map<String, Long> map) {
        Set<String> keys = map.keySet();
        keys.forEach(k ->
                System.out.printf("%s - %d сотрудник%s\n", k, map.get(k), getEnding(Math.toIntExact(map.get(k)))));
    }

    private static String getEnding(int count) {
        int var1 = count % 10;
        int var2 = count % 100;
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
