package ch.fhnw.atlantis.clientClasses.GUI;

/**
 * Created by Daniel on 18.11.2016.
 */

import java.io.*;
import java.net.Socket;

public class Client {

    private ClientComSocket clientComSocket;

    public int connectToServer(String host, Integer port) {
        try {
            Socket socketToServer = new Socket(host, port);
            clientComSocket = new ClientComSocket(socketToServer);
            new Thread(clientComSocket).start();
            return 1;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public void sendMessagetoServer(String message) {
        clientComSocket.send(message);
    }

}
