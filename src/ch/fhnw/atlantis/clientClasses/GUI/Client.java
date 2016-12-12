package ch.fhnw.atlantis.clientClasses.GUI;

/**
 * Created by Daniel on 18.11.2016.
 */

import java.io.*;
import java.net.Socket;

/**
 * Created by Stefan on 02.12.2016.
 */
public class Client {

    private ClientComSocket clientComSocket;

    public Client() {

    }

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

    //public static void main(String[] args) {
    //    Client client = new Client();
    //    client.connectToServer();
//
    //    try {
    //        Thread.sleep(1000);
    //    } catch (InterruptedException e) {
    //        e.printStackTrace();
    //    }
//
//
    //    while (true) {
    //        try {
    //            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    //            String message = br.readLine();
    //            if (message.equals("q")) {
    //                break;
    //            }
    //            client.sendMessagetoServer(message);
    //        } catch ( IOException e ) {
    //            e.printStackTrace();
    //        }
//
    //    }
//
    //}
}
