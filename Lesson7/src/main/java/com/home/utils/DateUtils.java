package com.home.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

import static com.home.utils.Constants.DATE_TIME_FORMAT;
import static com.home.utils.Constants.DATE_TIME_FORMAT1;

public class DateUtils {
    public static String print(Date date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_TIME_FORMAT);
        return dateFormat.format(date);
    }

    public static String print1(Date date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_TIME_FORMAT1);
        return dateFormat.format(date);
    }
}
