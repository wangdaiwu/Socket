package com.wdw.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
    public static String logDate() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        return dateFormat.format(new Date());
    }

    public static String fileDate() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd-HHmmss");
        return dateFormat.format(new Date());
    }
}
