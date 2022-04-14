package com.wdw.tcp.chat;

import com.wdw.service.ChatService;

import java.net.ServerSocket;
import java.net.Socket;

public class tcpReceiver {
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(8080);
        Socket socket = serverSocket.accept();
        ChatService.receiveMessage(socket);
    }
}
