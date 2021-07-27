package com.home.util;

import java.util.Scanner;

public class IOUtils {
    public static String getStringFromConsole(String message) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(message);
        return scanner.nextLine();
    }


}
