package com.home;

import static com.home.util.Constants.SMALL_TEXT;
import static org.apache.commons.lang3.StringUtils.reverse;

public class HomeWork13 {
    public static void main(String[] args) {
        String text = SMALL_TEXT;
        System.out.println(SMALL_TEXT);
        System.out.println("1) " + homeWork1(text));
        System.out.println("2) " + homeWork2(text));
        System.out.println("3)");
        homeWork3(text);

    }

    private static String homeWork1(String text) {
        int firstLetterIndex = text.indexOf('а');
        int secondLetterIndex = text.lastIndexOf('в');
        return text.substring(firstLetterIndex, secondLetterIndex);
    }

    private static String homeWork2(String text) {
        return text.replace(text.charAt(3), text.charAt(0));
    }

    private static void homeWork3(String text) {
        String editedText = text.replaceAll("[(),.:;!?{}-]", "");
        String[] words = editedText.split(" ");
        for (String word : words) {
            if (word.equals(reverse(word)) && word.length() > 1) {
                System.out.println(word);
            }
        }
    }
}
