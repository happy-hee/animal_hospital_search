package com.example.kdh.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.UUID;

public class TextUtils {

    public static boolean isEmpty(String text) {
        return text == null || text.length() == 0;
    }

    public static String clear(String query) {
        if (isEmpty(query)) return "";
        return query;
    }

    public static String makeKeyId(String header) {
        return makeKeyId(header, "yy");
    }

    public static String makeKeyId(String header, String pattern) {
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        String randomUUID = UUID.randomUUID().toString().replaceAll("_", "");

        return header + "_" + sdf.format(cal.getTime()) + "_" + randomUUID.substring(0, 6).toUpperCase();
    }

}