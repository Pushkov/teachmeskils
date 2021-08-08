package com.home.service;

import java.io.IOException;
import java.util.List;

public interface TextFormatter {

    List<String> readFileAsStringList(String path) throws IOException;

    String readFileAsString(String path) throws IOException;

    void createOrClearFile(String path) throws IOException;

    void addToFile(String text, String path) throws IOException;

    boolean isPalindrome(String word);

    boolean isPalindromeExists(String[] words);

    List<String> getSplittedSentences(String text);

    String[] getSplittedWords(String text);
}
