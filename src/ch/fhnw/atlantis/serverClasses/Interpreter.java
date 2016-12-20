package ch.fhnw.atlantis.serverClasses;

import ch.fhnw.atlantis.globalClasses.models.Player;
import ch.fhnw.atlantis.globalClasses.models.TileDeck;
import ch.fhnw.atlantis.serverClasses.serverClasses.GUI.ServerView;

import java.io.FileNotFoundException;

import static ch.fhnw.atlantis.globalClasses.models.Player.*;

/**
 * Created by Richard on 06/12/2016.
 */
public class Interpreter {

    public String interpretServerMsg(String messagefromClient) throws FileNotFoundException {

        String returnToClient;
        Player player = new Player();
        TileDeck tileDeck = new TileDeck();

        switch (messagefromClient) {
            case "StartGame":
                player.GameStart();
                returnToClient = "AskForGameBoard";
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
            case "GetPlayerOneHandTiles":
                returnToClient = "PlayerOnePTHand" + player.getPlayerHandTiles(1);
                System.out.println(returnToClient);
                break;
            case "GetPlayerTwoHandTiles":
                returnToClient = "PlayerTwoPTHand" + player.getPlayerHandTiles(2);
                break;
            case "ChangeTurnToPlayer1":
                returnToClient = "Player1Turn";
                break;
            case "ChangeTurnToPlayer2":
                returnToClient = "Player2Turn";
                break;
            case "ReturnGameBoard":
                returnToClient = "PathTileGameBoard_" + tileDeck.getGameBoard();
                System.out.println(returnToClient);
                break;
            //// 2DO! This case has to be done for each PT and each Player
            case "Player1_Played_MV_Blue":
                player.removeMovementCardFromHand(1, "MV_Blue");
                String Position = tileDeck.getPositionXY("MV_Blue");
player.updatePlayerHandTiles(1, Position.substring(9));
                //System.out.println(tileDeck.getPositionXY("MV_Blue"));
                returnToClient = "Player1_" + Position;
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
