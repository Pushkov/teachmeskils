package com.home.service;

import static org.apache.commons.lang3.StringUtils.reverse;

public class TextFormatterImpl implements TextFormatter {

    @Override
    public int getWordsCount(String text) {
        return getSplitedStringArray(text).length;
    }

    @Override
    public boolean isPalindromeExists(String text) {
        String[] words = getSplitedStringArray(text);
        for (String word : words) {
            if (word.length() > 1 && reverse(word).equals(word)) {
                return true;
            }
        }
        return false;
    }

    public String[] getSplitedStringArray(String text) {
        return text.replaceAll("[\"),:;!?{}-]", "").split(" ");
    }
}
