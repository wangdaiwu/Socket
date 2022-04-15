package com.wdw.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UdpSender {
    public static void main(String[] args) throws IOException {
        DatagramSocket socket = new DatagramSocket(8081);
        byte[] data = "hello".getBytes();
        DatagramPacket packet = new DatagramPacket(data, data.length, InetAddress.getLocalHost(), 8080);
        socket.send(packet);
    }
}
