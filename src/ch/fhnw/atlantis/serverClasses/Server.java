package ch.fhnw.atlantis.serverClasses;

/**
 * Created by Daniel on 18.11.2016.
 */
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server implements Runnable {
    private ServerThread client = null;
    private ServerSocket server = null;
    private Thread thread = null;

    public Server(int port) {
        try {
            System.out
                    .println("Binding to port " + port + ", please wait  ...");
            this.server = new ServerSocket(port);
            System.out
                    .println("Server started: " + server + " on port " + port);
            start();
        } catch (IOException ioe) {
            System.out.println("Can not bind to port " + port + ": "
                    + ioe.getMessage());
        }
    }

    public void run() {
        while (this.thread != null) {
            try {
                // System.out.println("Waiting for a client ...");
                addClient(this.server.accept());
            } catch (IOException ioe) {
                System.out.println("Server accept error: " + ioe);
                stop();
            }
        }
    }

    public void start() {
        if (this.thread == null) {
            this.thread = new Thread(this);
            this.thread.start();
        }
    }

    public void stop() {
        if (this.thread != null) {
            this.thread.stop();
            this.thread = null;
        }
    }

    private void addClient(Socket socket) {
        // System.out.println("Client accepted: " + socket);
        this.client = new ServerThread(this, socket);
        try {
            this.client.open();
            this.client.start();
        } catch (IOException ioe) {
            System.out.println("Error opening thread: " + ioe);
        }
    }

    public static void main(String args[]) {
        Server server = null;
        if (args.length != 1)
            System.out.println("Usage: java Server port");
        else
            server = new Server(Integer.parseInt(args[0]));
    }
}