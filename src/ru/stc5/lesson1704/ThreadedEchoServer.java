package ru.stc5.lesson1704;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by sergey on 17.04.17.
 */
public class ThreadedEchoServer {

    static final int PORT = 5555;

    public static void main(String args[]) {
        ServerSocket serverSocket = null;
        Socket socket = null;

        try {
            serverSocket = new ServerSocket(PORT);
        } catch (IOException e) {
            e.printStackTrace();
        }

        while (true) {
            try {
                socket = serverSocket.accept();
            } catch (IOException e) {
                System.out.println("I/O error: " + e);
            }

            new EchoThread(socket).start();
        }
    }
}

