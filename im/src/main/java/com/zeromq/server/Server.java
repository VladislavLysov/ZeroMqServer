package com.zeromq.server;

import org.zeromq.ZMQ;

/**
 * @author VladLysov
 */
public class Server {

    public static void main(String[] args) {
        try (ZMQ.Context context = ZMQ.context(1);
             ZMQ.Socket socket = context.socket(ZMQ.REP)) {
            socket.bind("tcp://*:5555");
            while (true) {
                byte[] req = socket.recv();
                System.out.println(new String(req));
                socket.send("Got itka");
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    // Ignore
                }
            }
        }
    }
}
