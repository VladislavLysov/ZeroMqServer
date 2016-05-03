package com.zeromq.client;

import org.zeromq.ZMQ;

/**
 * @author VladLysov
 */
public class Client {

    public static void main(String[] args) {
        try (ZMQ.Context context = ZMQ.context(1);
             ZMQ.Socket socket = context.socket(ZMQ.REQ);) {
            socket.connect("tcp://*:5555");
            String testString = "Hello World!!!";
            socket.send(testString);
        }
    }
}
