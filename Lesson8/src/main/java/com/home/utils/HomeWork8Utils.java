package com.home.utils;

public class HomeWork8Utils {

    public static String getEndingForRefueling(int count) {
        String ending = "���";
        if(count == 0){
            ending = "��";
        } else if(count == 1){
            ending = "��";
        }
        return ending;
    }

    public static String getEnding(int count) {
        int count10 = count % 10;
        int count100 = count % 100;
        String ending = "";
        if (count10 >= 2) {
            ending = "�";
        }
        if (count10 >= 5 || count10 == 0 || (count100 >= 11 & count100 <= 14)) {
            ending = "��";
        }
        return ending;
    }

}
