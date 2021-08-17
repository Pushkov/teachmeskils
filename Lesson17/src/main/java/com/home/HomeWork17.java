package com.home;

import com.home.library.LibraryMain;
import com.home.model.Car;
import org.apache.commons.lang3.StringUtils;

import java.util.*;

import static com.home.library.util.LibraryUtils.printMap;
import static com.home.util.MyUtil.*;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

public class HomeWork17 {
    public static void main(String[] args) {
        point1();
        point2();
        point3();
        point4();
        point5_1();
        point5_2();
        point6();
    }

    private static void point1() {
        System.out.println(" 1)");
        ArrayList<Integer> list = getIntegerList(10, 30);
        printCollection(list, true);
        System.out.println();
        list.stream()
                .map(number -> number * 2)
                .forEach(number -> printWord(number, true));
        System.out.println();
    }

    private static void point2() {
        System.out.println(" 2)");
        Set<Integer> set = getSet();
        printCollection(set, true);
        System.out.println("\n" + set.size());
        int count = (int) set.stream()
                .filter(integer -> integer % 2 == 0)
                .count();
        System.out.println(count);
    }

    private static void point3() {
        System.out.println(" 3)");
        List<String> listNames = List.of("john", "arya", "sansa");
        listNames.stream()
                .map(StringUtils::capitalize)
                .forEach(x -> printWord(x, true));
        System.out.println();
    }

    private static void point4() {
        System.out.println(" 4)");
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
        System.out.println(" 5.1)");
        var list = getPersonsList();
        list.stream()
                .filter(person -> person.getLastName().startsWith("Д"))
                .forEach(System.out::println);
    }

    private static void point5_2() {
        System.out.println(" 5.2)");
        var list = getPersonsList();
        Map<String, Long> personsByFirstLetterInLastName = list.stream()
                .collect(groupingBy(person -> person.getLastName().substring(0, 1), counting()));
        printMap(personsByFirstLetterInLastName);
    }

    private static void point6() {
        LibraryMain libraryMain = new LibraryMain();
        libraryMain.startLibrary();
    }
}
