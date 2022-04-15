package com.wdw.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class DateUtils {
    public static String logDate() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
//        dateFormat.setTimeZone(TimeZone.getTimeZone("Asia/Shanghai"));
        return dateFormat.format(new Date());
    }

    public static String fileDate() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd-HHmmss");
//        dateFormat.setTimeZone(TimeZone.getTimeZone("Asia/Shanghai"));
        return dateFormat.format(new Date());
    }
}
