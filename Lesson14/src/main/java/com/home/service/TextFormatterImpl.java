package com.home.service;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import static org.apache.commons.lang3.StringUtils.reverse;

public class TextFormatterImpl implements TextFormatter {


    public List<String> getFileByStringLines(String path) throws FileNotFoundException {
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

    public void createFile(String path) {
        String filePath = getUrl("/").getPath() + path;
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
            bw.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void addToFile(String text, String path) {
        String filePath = getUrl("/").getPath() + path;
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath, true))) {
            bw.write(text);
            bw.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public boolean isPalindrome(String word) {
        String wordInLowerCase = word.toLowerCase();
        if (word.length() > 1 && word.matches("[a-zA-Zа-яА-Я]+") && wordInLowerCase.equals(reverse(wordInLowerCase))) {
            return true;
        }
        return false;
    }

    public boolean isPalindromeExists(String text) {
        String[] words = getSplitedStringArray(text);
        for (String word : words) {
            if (isPalindrome(word)) {
                return true;
            }
        }
        return false;
    }

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
}
