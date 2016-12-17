package ch.fhnw.atlantis.serverClasses;

import com.sun.xml.internal.ws.message.ByteArrayAttachment;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Daniel on 02.12.2016.
 */
public class Server {

    private static Server instance;
    private int port;
    private ServerSocket serverSocket;
    private List<ServerClientHandler> socketList;

    private Server(int port) {
        this.port = port;
        socketList = new ArrayList<>();
    }

    public static Server getInstance(int port) {
        if (instance == null) {
            instance = new Server(port);
        }
        return instance;
    }

    public void addClient(ServerClientHandler sch) {
        socketList.add(sch);
    }
    public void removeClient(ServerClientHandler sch) {
        // How many Sockets are Connected
        //System.out.println(socketList);
        socketList.remove(sch);
        //System.out.println(socketList);
    }

    public void forwardMessage(String message, ServerClientHandler sender) {
        Iterator itr = socketList.iterator();

        while (itr.hasNext()) {
            ServerClientHandler sch = (ServerClientHandler) itr.next();
            //if (!sender.equals(sch)) {
                sch.send(message);
            //}
        }
    }

    // Sends message if only one client is connected
    public void forwardMessageToOne(String message, ServerClientHandler sender){
        Iterator itr = socketList.iterator();
        ServerClientHandler sch = (ServerClientHandler) itr.next();
        sch.send(message);
    }


    public void startTCP() {
        try {
            serverSocket = new ServerSocket(port);
            new Thread(new ServerTCPListener(serverSocket)).start();
        } catch ( IOException e ) {
            e.printStackTrace();
        }
    }

    public void stopTCP() {
        System.exit(0);
    }

}
