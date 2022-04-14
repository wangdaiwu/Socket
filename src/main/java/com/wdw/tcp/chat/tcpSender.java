package com.wdw.tcp.chat;

import com.wdw.service.ChatService;

public class tcpSender {
    public static void main(String[] args) throws Exception {
        ChatService.sendMessage("localhost", 8080);
    }
}
