package ch.fhnw.atlantis.clientClasses.GUI;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.SocketTimeoutException;

/**
 * Created by Daniel on 02.12.2016.
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
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        while (socketToServer.isConnected()) {
            try {
                final String messagefromServer = (String) inputStream.readObject();
                //System.out.println("Received Message from server: " + messagefromServer);

                // Forward message to interpreter
                Interpreter InterpretClientMessage = new Interpreter();
                InterpretClientMessage.interpretClientMsg(messagefromServer);

            } catch (IOException e) {
                e.printStackTrace();
                break;
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
