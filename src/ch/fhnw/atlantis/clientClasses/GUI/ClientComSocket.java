package ch.fhnw.atlantis.clientClasses.GUI;

import java.io.*;
import java.net.Socket;

/**
 * Created by Daniel
 */
public class ClientComSocket implements Runnable {

    private Object lock = new Object();
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
        synchronized (lock) {
            try {
                outputStream.writeObject(message);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void run() {
        while (socketToServer.isConnected()) {
            try {
                final Object messagefromServer = inputStream.readObject();
                System.out.println("Received Message from server: " + messagefromServer);

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
