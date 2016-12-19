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
            case "StartGame":
                player.GameStart();
                returnToClient = "RequestYourIdentity";
                break;
            case "DefineIdentity":
                returnToClient = "Your ID will be: " + String.valueOf(player.definePlayerIdentity());
                break;
            case "GetPlayerOneHand":
                returnToClient = "PlayerOneHand" + player.getPlayerOneHand();
                System.out.println(returnToClient);
                break;
            case "GetPlayerTwoHand":
                returnToClient = "PlayerTwoHand" + player.getPlayerTwoHand();
                System.out.println(returnToClient);
                break;
            //// 2DO! This case has to be done for each PT and each Player
            case "Player1_ExchangePathTileValue_pink_3.jpg":
                // change PT into MV
                getCardFromStack(3, 1);
                //// 2DO! Add still remove from PT hand
                // return updated hand
                returnToClient = "PlayerOneHand" + player.getPlayerOneHand();
                System.out.println(returnToClient);
                break;
            default:
                returnToClient = "Default Output";
                //System.out.println(returnToClient);
        }
        return returnToClient;
    }

}
