package com.home.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class TextFormatterImpl implements TextFormatter {

    public String getStringFromFile(String path) {
        String result = "";
/*
public String getResourceFileAsString(String fileName) {
    InputStream is = getClass().getClassLoader().getResourceAsStream(fileName);
    if (is != null) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        return reader.lines().collect(Collectors.joining(System.lineSeparator()));
    }
    return null;
}
 */

//            try (FileInputStream fin = new FileInputStream(path)) {
        try (InputStream is = getClass().getClassLoader().getResourceAsStream(path)) {
            System.out.printf("File size: %d bytes \n", is.available());
            if (is != null) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            }

//                int i = -1;
//                while ((i = is.read()) != -1) {
//
//                    System.out.print((char) i);
//                }
        } catch (IOException ex) {

            System.out.println(ex.getMessage());
        }
        return result;
    }
}
