package com.home;

import static com.home.util.Constants.SMALL_TEXT;
import static com.home.util.Constants.TEXT;
import static org.apache.commons.lang3.StringUtils.reverse;

public class HomeWork13 {
    public static void main(String[] args) {
        System.out.println(SMALL_TEXT);
        System.out.println("1) " + homeWork1(SMALL_TEXT));
        System.out.println("2) " + homeWork2(SMALL_TEXT));
        System.out.println("3)");
        homeWork3(SMALL_TEXT);
        System.out.println("4)");
        homeWork4(TEXT);
        System.out.println("4.1)");
        homeWork4(SMALL_TEXT);


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

    private static void homeWork4(String text) {
        String editedText = text;
        String[] words = editedText.split("\\.");
        for (String word : words) {
//            if (word.equals(reverse(word)) && word.length() > 1) {
            if (word.split(" ").length > 2 && word.split(" ").length < 6 || isPalindromeExists(word)) {
                System.out.println(word);
            }
        }
//        System.out.println(words.length);
    }

    private static boolean isPalindromeExists(String text) {
        boolean isPalindromeExists = false;
        String editedText = text.replaceAll("[(),.:;!?{}-]", "");
        String[] words = editedText.split(" ");
        for (String word : words) {
            if (word.equals(reverse(word)) && word.length() > 1) {
                isPalindromeExists = true;
            }
        }
        return isPalindromeExists;
    }

}
