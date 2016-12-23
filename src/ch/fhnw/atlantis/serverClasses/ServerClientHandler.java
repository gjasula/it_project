package ch.fhnw.atlantis.serverClasses;


import ch.fhnw.atlantis.globalClasses.Player;
import ch.fhnw.atlantis.globalClasses.TileDeck;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * @author Daniel
 */
public class ServerClientHandler implements Runnable {

    private Object lock = new Object();
    private Socket socketToClient;
    private ObjectOutputStream outputStream;
    private ObjectInputStream inputStream;
    private Server server;
    private int clientId;
    private int port;

    public ServerClientHandler(Socket socketToClient) {
        server = Server.getInstance(port);
        this.socketToClient = socketToClient;
        try {
            outputStream = new ObjectOutputStream(socketToClient.getOutputStream());
            inputStream = new ObjectInputStream(socketToClient.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    public void send(String message) {
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

        int SetIDUser = 0;

        while (socketToClient.isConnected()) {
            try {
                final Object messagefromClient = inputStream.readObject();

                // Forward message from server to interpreter
                Interpreter InterpretServerMessage = new Interpreter();
                String answerToClientString = InterpretServerMessage.interpretServerMsg(messagefromClient.toString());
                server.forwardMessage(answerToClientString, this);

                // Define ID for users directly after connecting
                if(SetIDUser == 0) {
                    server.forwardMessageToOne("DefineIdentity1", this);
                    SetIDUser = 1;
                }
                if(SetIDUser == 1){
                    server.forwardMessage("DefineIdentity2", this);
                    SetIDUser = 2;
                }

           } catch (IOException e) {
                e.printStackTrace();
                break;
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
}