package com.home.service;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TextFormatterImpl implements TextFormatter {

    @Override
    public List<String> getFileByStringLines(String path) throws IOException {
        List<String> stringList;
        URL fileUrl = getUrl(path);
        if (fileUrl != null) {
            stringList = readFileByLines(fileUrl);
        } else {
            throw new FileNotFoundException("Проверьте наличие файла " + path + " ...");
        }
        return stringList;
    }

    private List<String> readFileByLines(URL fileUrl) {
        List<String> stringList = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(fileUrl.getPath()))) {
            String line = br.readLine();
            while (line != null) {
                stringList.add(line);
                line = br.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringList;
    }

    @Override
    public String getFileByString(String path) throws FileNotFoundException {
        String result;
        URL fileUrl = getUrl(path);
        if (fileUrl != null) {
            result = readFileBySymbol(fileUrl);
        } else {
            throw new FileNotFoundException("Проверьте наличие файла " + path + " ...");
        }
        return result;
    }

    private String readFileBySymbol(URL fileUrl) {
        StringBuilder stringBuilder = new StringBuilder();
        try (FileReader fileReader = new FileReader(fileUrl.getPath())) {
            int symbol;
            while ((symbol = fileReader.read()) != -1) {
                stringBuilder.append((char) symbol);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringBuilder.toString();
    }


    private URL getUrl(String path) {
        return getClass().getResource(path);
    }

    @Override
    public void createFile(String path) {
        String filePath = getUrl("/").getPath() + path;
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
            bw.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void addToFile(String text, String path) {
        String filePath = getUrl("/").getPath() + path;
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath, true))) {
            bw.write(text);
            bw.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
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
        String[] words = getSplitedStringArray(text);
        for (String word : words) {
            if (isPalindrome(word)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String[] getSplitedSentences(String text) {
        String[] arr = text.replaceAll("-[\\n\\r]", "").replaceAll("\\s{2,}", "").split("[.!?]");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = arr[i].trim();
        }
        return arr;
    }

    public String[] getSplitedStringArray(String text) {
        return text.replaceAll("[\"),:;!?{}-]", "").replaceAll("\\s{2,}", "").split(" ");
    }

    public int getWordsCount(String text) {
        return getSplitedStringArray(text).length;
    }


    private boolean isFileExists(String fileName) {
        URL fileUrl = getClass().getClassLoader().getResource(fileName);
        return fileUrl != null;
    }

    public String infoFileSize(File file) {
        return "File " + file.getName() + " size: " + file.length() + " bytes \n";
    }


    public void analyzeText(String path) throws FileNotFoundException {
        URL fileUrl = getUrl(path);
        if (fileUrl != null) {
            List<String> textLines = readFileByLines2(fileUrl);
            String text = getConcatenatedString(textLines);
            List<String> sentencesList = getSentencesList(text);
        } else {
            throw new FileNotFoundException("Проверьте наличие файла " + path + " ...");
        }
    }

    private String getConcatenatedString(List<String> textLines) {
        StringBuilder stringBuilder = new StringBuilder();
        for (String line : textLines) {
            stringBuilder.append(line);
        }
        return stringBuilder.toString();
    }

    private List<String> getSentencesList(String text) {
        String[] sentences = text.split("[.!?]");
        return Arrays.stream(sentences)
                .map(this::getProcessedSentence)
                .collect(Collectors.toList());
    }

    private List<String> readFileByLines2(URL fileUrl) {
        List<String> stringList = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(fileUrl.getPath()))) {
            String line = br.readLine();
            while (line != null) {
                stringList.add(getProcessedLine(line));
                System.out.println(getProcessedLine(line));
                line = br.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringList;
    }

    private String getProcessedLine(String value) {
        return value.replaceAll("-\\s+", "")
                //        return value.trim()
//                .replaceAll("$", " ")
//                .replaceAll("- $", "")
//                .replaceAll("...", "\\.")
//                .replaceAll("\\s{2,}", "")
//                .replaceAll("-[\\n\\r]", "")
                ;
    }

    private String getProcessedSentence(String value) {
        return value.toLowerCase()
                .replaceAll("[.,:!?(){}-]", "")
                .trim();
    }

    private String getProcessedString(String value) {
        return value.toLowerCase()
                .trim();
    }
}
