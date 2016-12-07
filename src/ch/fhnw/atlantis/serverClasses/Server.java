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

    public static Server getInstance() {
        if (instance == null) {
            instance = new Server(7777);
        }
        return instance;
    }

    public void addClient(ServerClientHandler sch) {
        socketList.add(sch);
    }
    public void removeClient(ServerClientHandler sch) {
        socketList.remove(sch);
    }

    public void forwardMessage(String message, ServerClientHandler sender) {
        Iterator itr = socketList.iterator();

        while (itr.hasNext()) {
            ServerClientHandler sch = (ServerClientHandler) itr.next();
            if (!sender.equals(sch)) {
                sch.send(message);
            }
        }
    }


    public void startTCP() {
        try {
            serverSocket = new ServerSocket(port);
            new Thread(new ServerTCPListener(serverSocket)).start();
            System.out.println("Server started");
        } catch ( IOException e ) {
            e.printStackTrace();
        }
    }

    //public static void main(String[] args) {
    //    Server server = Server.getInstance();
//
    //    server.startTCP();
    //}
}
