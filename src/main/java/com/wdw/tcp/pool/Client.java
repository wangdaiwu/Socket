package com.wdw.tcp.pool;

import com.wdw.service.ChatService;

import java.io.*;

public class Client {
    public static void main(String[] args) throws IOException {
        ChatService.sendMessage("localhost", 8001);
    }
}
