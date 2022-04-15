package com.wdw.chat;

import com.wdw.service.ChatService;
import com.wdw.utils.LogUtils;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class User1 {
    public static void main(String[] args) throws Exception {
        new Thread() {
            @Override
            public void run() {
                try {
                    Thread.sleep(10000);
                    ChatService.sendMessageAndFile("localhost", 8002, 18002);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();

        new Thread() {
            @Override
            public void run() {
                try {
                    ServerSocket messageServerSocket = new ServerSocket(8001);
                    LogUtils.log("message-server", "startup successfully");
                    Socket socket = messageServerSocket.accept();
                    LogUtils.log("message-server", "client connect to server successfully");
                    ChatService.receiveMessage(socket);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }.start();

        new Thread() {
            @Override
            public void run() {
                try {
                    ServerSocket fileServerSocket = new ServerSocket(18001);
                    LogUtils.log("file-server", "startup successfully");
                    while (true) {
                        Socket socket = fileServerSocket.accept();
                        LogUtils.log("file-server", "client connect to server successfully");
                        ChatService.receiveFile(socket);
                        LogUtils.log("file-server", "client disconnect to server");
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }
}
