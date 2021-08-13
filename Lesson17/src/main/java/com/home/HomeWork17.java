package com.home;

import com.home.util.MyUtil;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static com.home.util.MyUtil.getIntegerList;
import static com.home.util.MyUtil.getSet;

public class HomeWork17 {
    public static void main(String[] args) {
//        point1();
//        point2();
        point3();
    }

    private static void point1() {
        ArrayList<Integer> list = getIntegerList(10, 30);
        list.forEach(MyUtil::printIntegerListPoint);
        System.out.println();
        list.stream()
                .map(number -> number * 2)
                .forEach(MyUtil::printIntegerListPoint);
    }

    private static void point2() {
        Set<Integer> set = getSet();
        set.forEach(MyUtil::printIntegerListPoint);
        System.out.println("\n" + set.size());
        long count = set.stream()
                .filter(integer -> integer % 2 == 0)
                .count();
        System.out.println(count);
    }

    private static void point3() {
        List<String> listNames = List.of("john", "arya", "sansa");
        listNames.stream()
                .map(StringUtils::capitalize)
                .forEach(MyUtil::printStringListPoint);

    }
}
