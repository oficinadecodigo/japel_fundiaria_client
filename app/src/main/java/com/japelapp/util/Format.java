package com.japelapp.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Format {

    private static String tryFormatDate(Date date) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateStr = null;
        try {
            dateStr = simpleDateFormat.format(date);
        } catch (Throwable ex) {
        }
        return dateStr;
    }

    private static Date tryParseDate(String dateStr) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = null;
        try {
            date = simpleDateFormat.parse(dateStr);
        } catch (Throwable ex) {
        }
        return date;
    }

}
