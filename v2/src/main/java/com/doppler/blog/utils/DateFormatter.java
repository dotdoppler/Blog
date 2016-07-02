package com.doppler.blog.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by doppler on 2016/5/28.
 */
public final class DateFormatter {
    private static DateFormat dateFormat = new SimpleDateFormat("MMM d, yyyy", Locale.ENGLISH);
    public static  String format(Date date){
        return dateFormat.format(date);
    }
}
