package com.home.service;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static com.home.util.Constants.*;

public class TextFormatterImpl implements TextFormatter {

    @Override
    public List<String> readFileAsStringList(String path) throws IOException {
        List<String> stringList = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                stringList.add(line.trim());
            }
        }
        return stringList;
    }

    @Override
    public String readFileAsString(String path) throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        try (FileReader fileReader = new FileReader(path)) {
            int symbol;
            while ((symbol = fileReader.read()) != -1) {
                stringBuilder.append((char) symbol);
            }
        }
        return getProcessedString(stringBuilder.toString());
    }

    private String getProcessedString(String text) {
        return text.replaceAll(LINE_SEPARATOR, "");
    }

    @Override
    public void createOrClearFile(String path) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path))) {
            bw.flush();
        }
    }

    @Override
    public void addToFile(String text, String path) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path, true))) {
            bw.write(text);
            bw.flush();
        }
    }

    @Override
    public boolean isPalindromeExists(String[] words) {
        for (String word : words) {
            if (isPalindrome(word)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean isPalindrome(String word) {
        String reverseWord = new StringBuilder(word).reverse().toString();
        if (word.length() > 1 && word.equalsIgnoreCase(reverseWord)) {
            return true;
        }
        return false;
    }

    @Override
    public List<String> getSplittedSentences(String text) {
        return List.of(text.split(SENTENCE_SEPARATOR))
                .stream()
                .map(String::trim)
                .collect(Collectors.toList());
    }

    @Override
    public String[] getSplittedWords(String text) {
        return text.split(WORD_SEPARATOR);
    }
}
