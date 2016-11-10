package ch.fhnw.atlantis.serverClasses;

/**
 * Created by Daniel on 25.10.2016.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;


public class Server {

    //Server starten

    public static void main(String[] args) throws IOException {
        ServerSocket listener = new ServerSocket(7777);
        try {
            while (true) {
                Socket socket = listener.accept();
                try {
                    PrintWriter out =
                            new PrintWriter(socket.getOutputStream(), true);
                    out.println(new Date().toString());
                } finally {
                    socket.close();
                }
            }
        }
        finally {
            listener.close();
        }
    }
}
