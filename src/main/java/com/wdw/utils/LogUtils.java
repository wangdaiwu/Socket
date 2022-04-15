package com.wdw.utils;

public class LogUtils {
    public static void log(String var1, String var2) {
        System.out.printf("%s --- [%16s] %s%n", DateUtils.logDate(), var1, var2);
    }

    public static void log(String var1, String var2, String var3) {
        System.out.printf("%s --- [%16s] %s : %s%n", DateUtils.logDate(), var1, var2, var3);
    }
}
