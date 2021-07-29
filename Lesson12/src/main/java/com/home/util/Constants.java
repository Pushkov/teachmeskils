package com.home.util;

import lombok.experimental.UtilityClass;

@UtilityClass
public class Constants {
        public static final int LOGIN_LENGTH = 3;
        public static final String PATTERN_LOGIN = "[^\\W_]\\w{" + (LOGIN_LENGTH - 1) + ",}";
        public static final int PASSWORD_LENGTH = 3;
        public static final String PATTERN_PASSWORD = "\\w{" + PASSWORD_LENGTH + ",}";
}
