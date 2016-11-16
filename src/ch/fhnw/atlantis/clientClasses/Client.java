package ch.fhnw.atlantis.clientClasses;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

import javax.swing.JOptionPane;

/**
 * Created by Daniel on 10.11.2016.
 
 */

public class Client {

    public static void main(String[] args) throws IOException {
        String serverAddress = JOptionPane.showInputDialog(
                "IP des Servers eingeben\n" +
                        "Service läuft auf Port 7777:");
        Socket s = new Socket(serverAddress, 7777);
        BufferedReader input =
                new BufferedReader(new InputStreamReader(s.getInputStream()));
        String answer = input.readLine();
        JOptionPane.showMessageDialog(null, answer);
        System.exit(0);
    }
}