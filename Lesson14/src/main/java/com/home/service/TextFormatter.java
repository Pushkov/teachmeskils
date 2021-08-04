package com.home.service;

import java.io.IOException;
import java.util.List;

public interface TextFormatter {

    List<String> getFileByStringLines(String path) throws IOException;

    String getFileByString(String path) throws IOException;

    void createFile(String path);

    void addToFile(String text, String path);

    boolean isPalindrome(String word);

    boolean isPalindromeExists(String text);

    String[] getSplitedSentences(String text);

}
