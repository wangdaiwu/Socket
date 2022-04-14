package com.wdw.utils;

import java.io.*;

public class StreamUtils {
    public static byte[] stream2ByteArray(InputStream is) throws Exception {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int len;
        while ((len = is.read(buffer)) != -1) {
            byteArrayOutputStream.write(buffer, 0, len);
        }
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        byteArrayOutputStream.close();
        return byteArray;
    }

    public static String stream2String(FileInputStream is) throws Exception {
        byte[] buffer = new byte[1024];
        int len = is.read(buffer);
        return new String(buffer, 0, len);
    }
}
