package ch.fhnw.atlantis.clientClasses.GUI;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Richard on 16/12/2016.
 */
public class PlayerClient {

    Client client = new Client();
    public static int PlayerID = 0;
    static List<String> PlayerOneHandCards = new ArrayList<>();
    static List<String> PlayerTwoHandCards = new ArrayList<>();
    static List<String> PlayerOneHandTiles = new ArrayList<>();
    static List<String> PlayerTwoHandTiles = new ArrayList<>();


    public void startGame() {
    }

    public void sendMessageToServer(String msg){
        client.connectToServer("127.0.0.1", 7777);
        client.sendMessagetoServer(msg);
    }

    public void setPlayerID(int playerID) {
        if (PlayerID == 0){
            PlayerID = playerID;
            System.out.println("[setPlayerID] My ID is: " + PlayerID);
            getPlayerOneMovementCard();
            getPlayerTwoMovementCard();
        }
    }

    public void getPlayerOneMovementCard(){
        sendMessageToServer("GetPlayerOneHand");
    }

    public void getPlayerTwoMovementCard(){
        sendMessageToServer("GetPlayerTwoHand");
    }

    public void setPlayerOneHandCards(String MVCard){
        String str[] = MVCard.split(",");
        PlayerOneHandCards = Arrays.asList(str);
        System.out.println("Player One Hand: " + PlayerOneHandCards);
    }

    public void setPlayerTwoHandCards(String MVCard){
        String str[] = MVCard.split(",");
        PlayerTwoHandCards = Arrays.asList(str);
        System.out.println("Player Two Hand: " + PlayerTwoHandCards);
    }

    public String getPlayerMovementCardHandGUI(int MovementCardNumber){
        // ONLY TESTING
        PlayerOneHandCards.add("MV_Blue");
        PlayerOneHandCards.add("MV_Grey");
        PlayerOneHandCards.add("MV_Green");
        PlayerOneHandCards.add("MV_Pink");
        PlayerOneHandCards.add("MV_White");

        String returnHand = "MV_Pink";

        returnHand = PlayerOneHandCards.get(MovementCardNumber);
        // ONLY TESTING ENDS

        if(PlayerID == 1){
            returnHand = PlayerOneHandCards.get(MovementCardNumber);
        }else if(PlayerID == 2){
            returnHand = PlayerTwoHandCards.get(MovementCardNumber);
        }

        return returnHand;
    }

    public String getPlayerPathTileHandGUI(int PathTileNumber){
        // ONLY TESTING
        PlayerOneHandTiles.add("pink_3.jpg");
        PlayerOneHandTiles.add("pink_1.jpg");
        PlayerOneHandTiles.add("pink_2.jpg");
        PlayerOneHandTiles.add("pink_4.jpg");
        PlayerOneHandTiles.add("pink_5.jpg");

        String returnHand = "pink_3.jpg";

        returnHand = PlayerOneHandTiles.get(PathTileNumber);
        // ONLY TESTING ENDS


        if(PlayerID == 1){
            // MovementCardNumber > PlayerOneHandTiles.size()
            // MovementCardNumber = 0 wird aber nicht gehen da sonst immer die letzte Karte angezeigt wird falls einmal durch
            returnHand = PlayerOneHandTiles.get(PathTileNumber);
        }else if(PlayerID == 2){
            returnHand = PlayerTwoHandTiles.get(PathTileNumber);
        }

        return returnHand;
    }

}
