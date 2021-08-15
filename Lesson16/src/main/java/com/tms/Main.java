package com.tms;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
//        teatArray();
        testSet();
    }

    private static void teatArray() {
        List<String> list = new ArrayList<>();
        list.add("123");
        list.add("124");
        list.add("125");
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            String it = iterator.next();
            if (it.equals("124")) {
                list.remove(it);
            }
            System.out.println(it);
        }
        System.out.println(list);
    }

    private static void testSet() {
        {
            Set<String> set = new HashSet<>();
            set.add("s1");
            Iterator<String> itSet = set.iterator();
            while (itSet.hasNext()) {
                System.out.println(itSet.next());
            }
        }
        {
            Set<String> lSet = new LinkedHashSet<>();
            lSet.add("1");
            lSet.add("2");
            lSet.add("1");
            System.out.println(lSet);
            System.out.println(lSet.toArray()[0]);
            System.out.println(lSet.stream().filter(s -> s.equals("2")).collect(Collectors.toList()));
        }
    }

    private static void test3() {


    }

}
