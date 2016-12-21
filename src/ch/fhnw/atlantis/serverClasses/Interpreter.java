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
            case "ReturnPawnOnLand":
                returnToClient = "SpielfigurenImZiel" + player.getPlayerOnLand();
                System.out.println(returnToClient);
                break;
            //// 2DO! This case has to be done for each PT and each Player
            case "Player1_Played_MV_Blue":
                player.removeMovementCardFromHand(1, "MV_Blue");
                String PositionBlue = tileDeck.getPositionXY(1, "MV_Blue");
                player.updatePlayerHandTiles(1, PositionBlue.substring(9));
                returnToClient = "Player1_" + PositionBlue;
                break;
            case "Player1_Played_MV_Brown":
                player.removeMovementCardFromHand(1, "MV_Brown");
                String PositionBrown = tileDeck.getPositionXY(1, "MV_Brown");
                player.updatePlayerHandTiles(1, PositionBrown.substring(9));
                returnToClient = "Player1_" + PositionBrown;
                break;
            case "Player1_Played_MV_Green":
                player.removeMovementCardFromHand(1, "MV_Green");
                String PositionGreen = tileDeck.getPositionXY(1, "MV_Green");
                player.updatePlayerHandTiles(1, PositionGreen.substring(9));
                returnToClient = "Player1_" + PositionGreen;
                break;
            case "Player1_Played_MV_Grey":
                player.removeMovementCardFromHand(1, "MV_Grey");
                String PositionGrey = tileDeck.getPositionXY(1, "MV_Grey");
                player.updatePlayerHandTiles(1, PositionGrey.substring(9));
                returnToClient = "Player1_" + PositionGrey;
                break;
            case "Player1_Played_MV_Pink":
                player.removeMovementCardFromHand(1, "MV_Pink");
                String PositionPink = tileDeck.getPositionXY(1, "MV_Pink");
                player.updatePlayerHandTiles(1, PositionPink.substring(9));
                returnToClient = "Player1_" + PositionPink;
                break;
            case "Player1_Played_MV_White":
                player.removeMovementCardFromHand(1, "MV_White");
                String PositionWhite = tileDeck.getPositionXY(1, "MV_White");
                player.updatePlayerHandTiles(1, PositionWhite.substring(9));
                returnToClient = "Player1_" + PositionWhite;
                break;
            case "Player1_Played_MV_Yellow":
                player.removeMovementCardFromHand(1, "MV_Yellow");
                String PositionYellow = tileDeck.getPositionXY(1, "MV_Yellow");
                player.updatePlayerHandTiles(1, PositionYellow.substring(9));
                returnToClient = "Player1_" + PositionYellow;
                break;
            case "Player2_Played_MV_Blue":
                player.removeMovementCardFromHand(2, "MV_Blue");
                String PositionBlue2 = tileDeck.getPositionXY(2, "MV_Blue");
                player.updatePlayerHandTiles(2, PositionBlue2.substring(9));
                returnToClient = "Player2_" + PositionBlue2;
                break;
            case "Player2_Played_MV_Brown":
                player.removeMovementCardFromHand(2, "MV_Brown");
                String PositionBrown2 = tileDeck.getPositionXY(2, "MV_Brown");
                player.updatePlayerHandTiles(2, PositionBrown2.substring(9));
                returnToClient = "Player2_" + PositionBrown2;
                break;
            case "Player2_Played_MV_Green":
                player.removeMovementCardFromHand(2, "MV_Green");
                String PositionGreen2 = tileDeck.getPositionXY(2, "MV_Green");
                player.updatePlayerHandTiles(2, PositionGreen2.substring(9));
                returnToClient = "Player2_" + PositionGreen2;
                break;
            case "Player2_Played_MV_Grey":
                player.removeMovementCardFromHand(2, "MV_Grey");
                String PositionGrey2 = tileDeck.getPositionXY(2, "MV_Grey");
                player.updatePlayerHandTiles(2, PositionGrey2.substring(9));
                returnToClient = "Player2_" + PositionGrey2;
                break;
            case "Player2_Played_MV_Pink":
                player.removeMovementCardFromHand(2, "MV_Pink");
                String PositionPink2 = tileDeck.getPositionXY(2, "MV_Pink");
                player.updatePlayerHandTiles(2, PositionPink2.substring(9));
                returnToClient = "Player2_" + PositionPink2;
                break;
            case "Player2_Played_MV_White":
                player.removeMovementCardFromHand(2, "MV_White");
                String PositionWhite2 = tileDeck.getPositionXY(2, "MV_White");
                player.updatePlayerHandTiles(2, PositionWhite2.substring(9));
                returnToClient = "Player2_" + PositionWhite2;
                break;
            case "Player2_Played_MV_Yellow":
                player.removeMovementCardFromHand(2, "MV_Yellow");
                String PositionYellow2 = tileDeck.getPositionXY(2, "MV_Yellow");
                player.updatePlayerHandTiles(2, PositionYellow2.substring(9));
                returnToClient = "Player2_" + PositionYellow2;
                break;







            //// 2DO! This case has to be done for each PT and each Player
            case "Player1_ExchangePathTileValue_pink_3.jpg":
                // change PT into MV
                getCardFromStack(3, 1);
                player.removePathTileFromHand(1,"pink_3.jpg");
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
