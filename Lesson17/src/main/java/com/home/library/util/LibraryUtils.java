package com.home.library.util;

import com.home.library.model.Book;
import lombok.experimental.UtilityClass;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;

@UtilityClass
public class LibraryUtils {

    public static void print(Map<String, Long> map) {
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

    public static int createId(List<Book> list) {
        return list.stream()
                .map(Book::getId)
                .max(Comparator.naturalOrder())
                .orElse(0) + 1;
    }
}
