package com.wdw.service;

import com.wdw.utils.DateUtils;
import com.wdw.utils.LogUtils;
import com.wdw.utils.StreamUtils;

import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class ChatService {
    public static void sendMessage(String var1, int var2) {
        try {
            try (Socket massageSocket = new Socket(var1, var2);
                 BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
                 FileOutputStream out = (FileOutputStream) massageSocket.getOutputStream()) {
                boolean flag = true;
                while (flag) {
                    String message = in.readLine();
                    LogUtils.log("client", "send", message);
                    out.write(message.getBytes(StandardCharsets.UTF_8));
                    if ("/bye".equals(message)) {
                        flag = false;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void sendMessageAndFile(String var1, int var2, int var3) {
        sendMessageAndFile(var1, var2, var1, var3);
    }

    public static void sendMessageAndFile(String var1, int var2, String var3, int var4) {
        try {
            try (Socket massageSocket = new Socket(var1, var2);
                 BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
                 FileOutputStream out = (FileOutputStream) massageSocket.getOutputStream()) {
                boolean flag = true;
                while (flag) {
                    String message = in.readLine();
                    LogUtils.log("client", "send", message);
                    out.write(message.getBytes(StandardCharsets.UTF_8));
                    if ("/bye".equals(message)) {
                        flag = false;
                    } else if ("/file".equals(message)) {
                        sendFile(var3, var4);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void receiveMessage(Socket socket) {
        try {
            try (FileInputStream in = (FileInputStream) socket.getInputStream()) {
                boolean flag = true;
                while (flag) {
                    String message = StreamUtils.stream2String(in);
                    if ("/bye".equals(message)) {
                        flag = false;
                    }
                    LogUtils.log("message-server", "receive", message);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static final String SRC_FILE_PATH = "src\\src.md";

    private static void sendFile(String host, int port) {
        try {
            try (Socket fileSocket = new Socket(host, port);
                 FileOutputStream fos = (FileOutputStream) fileSocket.getOutputStream();
                 FileInputStream fis = new FileInputStream(SRC_FILE_PATH)) {
                byte[] bytes = StreamUtils.stream2ByteArray(fis);
                LogUtils.log("client", "load file form disk");
                fos.write(bytes);
                LogUtils.log("client", "send file");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static final String DES_FILE_PATH_PREFIX = "src\\des-";
    private static final String DES_FILE_PATH_SUFFIX = ".md";

    public static void receiveFile(Socket socket) {
        try {
            String desFilePath = DES_FILE_PATH_PREFIX + DateUtils.fileDate() + DES_FILE_PATH_SUFFIX;
            try (FileInputStream fis = (FileInputStream) socket.getInputStream();
                 FileOutputStream fos = new FileOutputStream(desFilePath)) {
                byte[] bytes = StreamUtils.stream2ByteArray(fis);
                LogUtils.log("file-server", "receive file");
                fos.write(bytes);
                LogUtils.log("file-server", "dump file to disk");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
