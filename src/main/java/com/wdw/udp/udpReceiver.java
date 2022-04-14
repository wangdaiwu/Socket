package com.wdw.udp;

import com.wdw.utils.DateUtils;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class udpReceiver {
    public static void main(String[] args) throws IOException {
        DatagramSocket socket = new DatagramSocket(8080);

        byte[] buffer = new byte[1024];
        DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
        socket.receive(packet);

        int packetLength = packet.getLength();
        byte[] packetData = packet.getData();
        String s = new String(packetData, 0, packetLength);
        System.out.printf("[%s] %s", DateUtils.logDate(), s);
    }
}
