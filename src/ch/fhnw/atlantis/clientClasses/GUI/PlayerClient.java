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
        String returnHand = "MV_Pink";

        if(PlayerID == 1){
            returnHand = PlayerOneHandCards.get(MovementCardNumber);
        }else if(PlayerID == 2){
            returnHand = PlayerTwoHandCards.get(MovementCardNumber);
        }

        return returnHand;
    }

    public String getPlayerPathTileHandGUI(int MovementCardNumber){
        String returnHand = "pink_3.jpg";

        if(PlayerID == 1){
            returnHand = PlayerOneHandTiles.get(MovementCardNumber);
        }else if(PlayerID == 2){
            returnHand = PlayerTwoHandTiles.get(MovementCardNumber);
        }

        return returnHand;
    }

}
