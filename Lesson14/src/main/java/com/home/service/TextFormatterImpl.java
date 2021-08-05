package com.home.service;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TextFormatterImpl implements TextFormatter {

    @Override
    public List<String> readFileAsStringList(String path) throws IOException {
        List<String> stringList = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line = br.readLine();
            while (line != null) {
                stringList.add(line.trim());
                line = br.readLine();
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

    @Override
    public void createFile(String path) throws IOException {
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
    public boolean isPalindrome(String word) {
        String reverseWord = new StringBuilder(word).reverse().toString();
        if (word.length() > 1 && word.matches("[a-zA-Zа-яА-Я]+") && word.equalsIgnoreCase(reverseWord)) {
            return true;
        }
        return false;
    }

    @Override
    public boolean isPalindromeExists(String text) {
        for (String word : text.split(" ")) {
            if (isPalindrome(word)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public List<String> getSplitedSentences(String text) {
        return List.of(text.split("[.!?]"))
                .stream()
                .map(String::trim)
                .collect(Collectors.toList());
    }

    private String getProcessedString(String text) {
        return text.replaceAll("-*\r\n", "");
    }


//    public List<String> getSplitedStringArray2(String text) {
//        List<String> stringList = new ArrayList<>();
//        BreakIterator iterator = BreakIterator.getSentenceInstance();
//        iterator.setText(text);
//        int start = iterator.first();
//        for (int end = iterator.next(); end != BreakIterator.DONE ; start = end, end = iterator.next()) {
//            stringList.add(text.substring(start,end));
//        }
//        return stringList;
//    }

    @Override
    public int getWordsCount(String text) {
        return text.split(" ").length;
    }
}
