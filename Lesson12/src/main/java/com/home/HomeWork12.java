package com.home;

import static com.home.util.Constants.Banners.CONFIRM_PASSWORD;
import static com.home.util.Constants.Banners.PASSWORD;
import static com.home.util.Constants.Validation.PATTERN_LOGIN;

public class HomeWork12 {
    public static void main(String[] args) {


        String login = "1Dsasadsad_sdfds87987_231_3";
//        String login = IOUtils.getStringFromConsole(LOGIN);
        System.out.println(PASSWORD);
        System.out.println(CONFIRM_PASSWORD);

        System.out.println(PATTERN_LOGIN + " > " + login.length());
        System.out.println(login.matches(PATTERN_LOGIN));


    }
}
