package ch.fhnw.atlantis.serverClasses;

/**
 * Created by Richard on 06/12/2016.
 */
public class RichyRunToBeDeleted {

    private ServerClientHandler ServerCH;



    public static void main(String[] args) {

        //RichyRunToBeDeleted test = new RichyRunToBeDeleted();
        //writeMessage("test");

    }

    public RichyRunToBeDeleted(ServerClientHandler test){
        ServerCH = test;

    }

    public void writeMessage(String msg) {

       // ServerClientHandler test2 = new ServerClientHandler();
        ServerCH.send(msg);
    }

}
