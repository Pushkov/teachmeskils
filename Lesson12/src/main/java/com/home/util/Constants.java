package com.home.util;

public class Constants {
    public class Banners {
        public static final String LOGIN = "########################\n#    Введите логин     #\n########################\n> ";
        public static final String PASSWORD = "########################\n#    Введите пароль    #\n########################\n> ";
        public static final String CONFIRM_PASSWORD = "########################\n#  Подтвердите пароль  #\n########################\n> ";
    }

    public class Validation {
        public static final int LOGIN_LENGTH = 2;
        public static final String PATTERN_LOGIN = "[^_]\\w{" + LOGIN_LENGTH + ",}";
        public static final int PASSWORD_LENGTH = 2;
        public static final String PATTERN_PASSWORD = "\\w{" + PASSWORD_LENGTH + ",}";
    }
}
