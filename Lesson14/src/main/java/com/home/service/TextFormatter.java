package com.home.service;

import java.io.IOException;
import java.util.List;

public interface TextFormatter {

    List<String> readFileAsStringList(String path) throws IOException;

    String readFileAsString(String path) throws IOException;

    void createFile(String path) throws IOException;

    void addToFile(String text, String path) throws IOException;

    boolean isPalindrome(String word);

    boolean isPalindromeExists(String text);

    List<String> getSplitedSentences(String text);

    int getWordsCount(String text);

}
