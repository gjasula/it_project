package ch.fhnw.atlantis.serverClasses;

/**
 * Created by Daniel on 18.11.2016.
 */
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server implements Runnable {
    private Socket socket = null;
    private ServerThread client = null;
    private ServerSocket server = null;
    private Thread thread = null;
    private DataOutputStream streamOut = null;

    public Server(int port) {
        try {
            System.out
                    .println("Binding to port " + port + ", please wait  ...");
            this.server = new ServerSocket(port);
            this.socket = server.accept();

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
                System.out.println(this.thread + "OUT threadName");
                this.streamOut.writeUTF("Server zu Client");

                addClient(this.server.accept());
            } catch (IOException ioe) {
                System.out.println("Server accept error: " + ioe);
                stop();
            }
        }
    }

    public void start() throws IOException {
        this.streamOut = new DataOutputStream(socket.getOutputStream());
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

        // Selbstinitialisierung das müsste danach ins Server GUI MAIN
        server = new Server(Integer.parseInt(String.valueOf(7788)));

        if (args.length != 1)
            System.out.println("Usage: java Server port");
        else
            server = new Server(Integer.parseInt(String.valueOf(7777)));
    }
}