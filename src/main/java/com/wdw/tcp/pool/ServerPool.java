package com.wdw.tcp.pool;

import com.wdw.service.ChatService;
import com.wdw.utils.LogUtils;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerPool {
    private static final Integer THREAD_POOL_SIZE = 2;

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(8001);
        LogUtils.log("message-server", "startup successfully");

        for (int i = 0; i < THREAD_POOL_SIZE; i++) {
            new Thread() {
                @Override
                public void run() {
                    while (true) {
                        try {
                            Socket socket = server.accept();
                            LogUtils.log("message-server", "one client connect to server successfully");
                            ChatService.receiveMessage(socket);
                            LogUtils.log("message-server", "one client disconnect to server");
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }.start();
        }
    }
}
