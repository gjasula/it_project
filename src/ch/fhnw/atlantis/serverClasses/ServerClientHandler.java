package ch.fhnw.atlantis.serverClasses;


import ch.fhnw.atlantis.globalClasses.models.Player;
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

        int SetIDUser = 0;
        Player player = new Player();

        while (socketToClient.isConnected()) {
            try {
                final String messagefromClient = (String) inputStream.readObject();

                // Forward message from server to interpreter
                Interpreter InterpretServerMessage = new Interpreter();
                String answerToClientString = InterpretServerMessage.interpretServerMsg(messagefromClient);
                server.forwardMessage(answerToClientString, this);
                System.out.println("Server to Client: " + answerToClientString);

                // Define ID for users directly after connecting
                if(SetIDUser == 0) {
                    server.forwardMessageToOne("DefineIdentity1", this);
                    SetIDUser = 1;
                }
                if(SetIDUser == 1){
                    server.forwardMessage("DefineIdentity2", this);
                    SetIDUser = 2;
                }

                //server.forwardMessage("PlayerOneHand" + player.getPlayerOneHand(), this);

                //server.removeClient(this);

                //System.out.println("Received Message from client ("+socketToClient.hashCode()+"): " + messagefromClient);
                //server.forwardMessage("client ("+socketToClient.hashCode()+"):" + messagefromClient, this);
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