package ch.fhnw.atlantis.serverClasses;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Daniel on 02.12.2016.
 */

public class ServerTCPListener implements Runnable {

    private ServerSocket serverSocket;
    private Server server;
    private int port;

    public ServerTCPListener(ServerSocket serverSocket) {
        this.serverSocket = serverSocket;
        server = Server.getInstance(port);
    }

    @Override
    public void run() {
        while (!serverSocket.isClosed()) {
            try {
                final Socket socketToClient = serverSocket.accept();

                System.out.println(socketToClient);

                System.out.println("Client connected form: " + socketToClient.getInetAddress().toString());
                final ServerClientHandler sch = new ServerClientHandler(socketToClient);
                server.addClient(sch);
                new Thread(sch).start();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
