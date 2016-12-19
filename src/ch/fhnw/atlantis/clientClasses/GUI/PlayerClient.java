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
    public static int PlayersTurn = 1; // Welcher Spiler ist am Zug?
    static List<String> PlayerOneHandCards = new ArrayList<>();
    static List<String> PlayerTwoHandCards = new ArrayList<>();
    static List<String> PlayerOneHandTiles = new ArrayList<>();
    static List<String> PlayerTwoHandTiles = new ArrayList<>();
    static List<String> PathTileList = new ArrayList<>();


    public void startGame() {
    }

    public void sendMessageToServer(String msg){
        client.connectToServer("127.0.0.1", 7777);
        client.sendMessagetoServer(msg);
        System.out.println("Sending this to server: "+msg);
    }

    public void addPlayerToString(String msg){
        sendMessageToServer("Player1_"+msg);
        if(PlayerID == 1){
            sendMessageToServer("Player1_"+msg);
        }
        else if(PlayerID == 2){
            sendMessageToServer("Player2_"+msg);
        }
    }

    public void setPlayerID(int playerID) {
        if (PlayerID == 0){
            PlayerID = playerID;
            System.out.println("[setPlayerID] My ID is: " + PlayerID);
            getPlayerOneMovementCard();
            getPlayerTwoMovementCard();
        }
    }

    public void closeMyTurn(){
        if(PlayersTurn == 1){
            sendMessageToServer("ChangeTurnToPlayer2");
        }else if(PlayersTurn == 2){
            sendMessageToServer("ChangeTurnToPlayer1");
        }
    }

    public boolean isItMyTurn(){
        System.out.println("PlayerID: " + PlayerID);
        System.out.println("PlayersTurn: " + PlayersTurn);
        if(PlayerID == PlayersTurn){
            return false;
        }
        else {
            return true;
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

    public void setGameBoard(String PTString){
        String str[] = PTString.split(",");
        PathTileList = Arrays.asList(str);
        System.out.println("GameBoard PathTiles: " + PathTileList);
    }

    public String getTileImage(int PathTileNumber){

        String nextTile = null;

        nextTile = PathTileList.get(PathTileNumber);

        return nextTile;
    }

    public String getPlayerMovementCardHandGUI(int MovementCardNumber){

        String returnHand;

        // Damit man nur einen Next Button benötigt.
        if(MovementCardNumber >= PlayerOneHandCards.size()){
            double nr1;
            long nr2;

            nr1 = MovementCardNumber / PlayerOneHandCards.size();
            nr2 = (long) nr1;
            MovementCardNumber = (int) (MovementCardNumber - (nr2 * PlayerOneHandCards.size()));
        }

        returnHand = PlayerOneHandCards.get(MovementCardNumber);

        if(PlayerID == 1){
            returnHand = PlayerOneHandCards.get(MovementCardNumber);
        }else if(PlayerID == 2){
            returnHand = PlayerTwoHandCards.get(MovementCardNumber);
        }

        return returnHand;
    }

    public String getPlayerPathTileHandGUI(int PathTileNumber){
        // ONLY TESTING
        PlayerOneHandTiles.add("pink_1.jpg");
        PlayerOneHandTiles.add("pink_2.jpg");
        PlayerOneHandTiles.add("pink_3.jpg");
        PlayerOneHandTiles.add("pink_4.jpg");
        PlayerOneHandTiles.add("pink_5.jpg");
        PlayerTwoHandTiles.add("pink_5.jpg");
        PlayerTwoHandTiles.add("pink_5.jpg");
        PlayerTwoHandTiles.add("pink_5.jpg");
        PlayerTwoHandTiles.add("pink_5.jpg");

        String returnHand;

        // Damit man nur einen Next Button benötigt.
        if(PathTileNumber >= PlayerOneHandTiles.size()){
            double nr1;
            long nr2;

            nr1 = PathTileNumber / PlayerOneHandTiles.size();
            nr2 = (long) nr1;
            PathTileNumber = (int) (PathTileNumber - (nr2 * PlayerOneHandTiles.size()));
        }


        returnHand = PlayerOneHandTiles.get(PathTileNumber);

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
