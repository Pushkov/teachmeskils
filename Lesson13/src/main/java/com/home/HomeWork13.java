package com.home;

import com.home.service.TextFormatter;
import com.home.service.TextFormatterImpl;

import static com.home.util.Constants.*;
import static org.apache.commons.lang3.StringUtils.reverse;

public class HomeWork13 {

    private static TextFormatter textFormatter = new TextFormatterImpl();

    public static void main(String[] args) {
        System.out.println(SMALL_TEXT);
        System.out.println("1) " + homeWork1(SMALL_TEXT));
        System.out.println("2) " + homeWork2(SMALL_TEXT));
        System.out.println("3)");
        homeWork3(SMALL_TEXT);
        System.out.println("4)");
        homeWork4(TEXT);
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
        String[] words = ((TextFormatterImpl) textFormatter).getSplitedStringArray(text);
        for (String word : words) {
            if (word.equals(reverse(word)) && word.length() > 1) {
                System.out.println(word);
            }
        }
    }

    private static void homeWork4(String text) {
        String[] sentences = text.split("\\.");
        for (String sentence : sentences) {
            int wordCount = textFormatter.getWordsCount(sentence);
            if ((wordCount >= MIN_SIZE && wordCount <= MAX_SIZE) || textFormatter.isPalindromeExists(sentence)) {
                System.out.println(sentence);
            }
        }
    }
}
