package com.wdw.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
    public static String logDate() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS");
        return simpleDateFormat.format(new Date());
    }

    public static String fileDate() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd-hhmmss");
        return simpleDateFormat.format(new Date());
    }
}
