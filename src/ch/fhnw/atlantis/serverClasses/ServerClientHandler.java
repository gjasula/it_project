package ch.fhnw.atlantis.serverClasses;


import ch.fhnw.atlantis.serverClasses.serverClasses.GUI.ServerController;
import ch.fhnw.atlantis.serverClasses.serverClasses.GUI.ServerView;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * Created by Daniel on 02.12.2016.
 */
public class ServerClientHandler implements Runnable {

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
        try {
            outputStream.writeObject(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        while (socketToClient.isConnected()) {
            try {
                final String messagefromClient = (String) inputStream.readObject();

                //Forward Message from Server to Interpreter
                Interpreter InterpretServerMessage = new Interpreter();
                InterpretServerMessage.interpretServerMsg(messagefromClient);

                ServerView serverView = new ServerView();
                serverView.setTxtLog("Received Message from client");

                //System.out.println("Received Message from client ("+socketToClient.hashCode()+"): " + messagefromClient);
                server.forwardMessage("client ("+socketToClient.hashCode()+"):" + messagefromClient, this);
            } catch (IOException e) {
                e.printStackTrace();
                Server.getInstance(port).removeClient(this);
                break;
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
}