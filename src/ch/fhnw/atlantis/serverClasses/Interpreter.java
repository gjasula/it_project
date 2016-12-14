package ch.fhnw.atlantis.serverClasses;

import ch.fhnw.atlantis.globalClasses.models.Player;
import ch.fhnw.atlantis.serverClasses.serverClasses.GUI.ServerView;

import static ch.fhnw.atlantis.globalClasses.models.Player.*;

/**
 * Created by Richard on 06/12/2016.
 */
public class Interpreter {

    public String interpretServerMsg(String messagefromClient){

        String returnToClient;
        Player player = new Player();

        switch (messagefromClient) {
            case "PlayerConnected":
                returnToClient = "[Monday] specific output from client to server interpreter";
                System.out.println(returnToClient);
                break;
            case "DefineIdentity":
                returnToClient = String.valueOf(player.definePlayerIdentity());
                System.out.println("DefineIdentity: " + returnToClient);
            default:
                returnToClient = "Default Output";
                //System.out.println(returnToClient);
        }
        return returnToClient;
    }

}
