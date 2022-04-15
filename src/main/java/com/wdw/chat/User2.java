package com.wdw.chat;

import com.wdw.service.ChatService;
import com.wdw.utils.LogUtils;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class User2 {
    public static void main(String[] args) throws Exception{
        new Thread() {
            @Override
            public void run() {
                    ChatService.sendMessageAndFile("localhost", 8001, 18001);
            }
        }.start();

        new Thread() {
            @Override
            public void run() {
                try {
                    ServerSocket messageServerSocket = new ServerSocket(8002);
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
                    ServerSocket fileServerSocket = new ServerSocket(18002);
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
