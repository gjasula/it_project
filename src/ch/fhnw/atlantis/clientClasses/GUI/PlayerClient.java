package ch.fhnw.atlantis.clientClasses.GUI;

import ch.fhnw.atlantis.globalClasses.models.Tile;
import ch.fhnw.atlantis.globalClasses.models.TileDeck;

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
}
