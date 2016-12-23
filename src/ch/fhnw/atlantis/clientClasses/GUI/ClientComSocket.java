package ch.fhnw.atlantis.clientClasses.GUI;

import java.io.*;
import java.net.Socket;
import java.net.SocketTimeoutException;

/**
 * Created by Daniel
 */
public class ClientComSocket implements Runnable {

    private Socket socketToServer;
    private ObjectInputStream inputStream;
    private ObjectOutputStream outputStream;

    public ClientComSocket(Socket socketToServer) {
        this.socketToServer = socketToServer;
        try {
            inputStream = new ObjectInputStream(socketToServer.getInputStream());
            outputStream = new ObjectOutputStream(socketToServer.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void send(String message){
        try {
            outputStream.writeObject(message);
            Thread.sleep(200);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        while (socketToServer.isConnected()) {
            try {
                Thread.sleep(300);
                final Object messagefromServer = inputStream.readObject();
                Thread.sleep(300);
                System.out.println("Received Message from server: " + messagefromServer);
                Thread.sleep(300);

                // Forward message to interpreter
                Interpreter InterpretClientMessage = new Interpreter();
                InterpretClientMessage.interpretClientMsg(messagefromServer.toString());

            } catch (IOException e) {
                e.printStackTrace();
                break;
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
}
