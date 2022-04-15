package com.wdw.tcp.chat;

import com.wdw.service.ChatService;

public class TcpSender {
    public static void main(String[] args) {
        ChatService.sendMessage("localhost", 8080);
    }
}
