package ch.fhnw.atlantis.clientClasses.GUI;

import java.io.FileNotFoundException;

/**
 * Created by Richard on 10/12/2016.
 */
public class Interpreter {

    PlayerClient playerClient = new PlayerClient();
    DefinePawnPosition definePawnPosition = new DefinePawnPosition();

    public String interpretClientMsg(String messagefromServer) throws FileNotFoundException {

        switch (messagefromServer) {
            case "StartGame":
                playerClient.sendMessageToServer(messagefromServer);
                break;
            case "DefineIdentity1":
                playerClient.setPlayerID(1);
                break;
            case "DefineIdentity2":
                playerClient.setPlayerID(2);
                break;
            case "ExchangePathTile":
                playerClient.sendMessageToServer("ExchangePathTile");
                break;
            case "AskForGameBoard":
                playerClient.sendMessageToServer("ReturnGameBoard");
                break;
            case "Player1Turn":
                playerClient.PlayersTurn = 1;
                break;
            case "Player2Turn":
                playerClient.PlayersTurn = 2;
                break;
            default:

                if(messagefromServer.substring(0,13).equals("PlayerOneHand")){
                    playerClient.setPlayerOneHandCards(messagefromServer.substring(13));
                }else if(messagefromServer.substring(0,13).equals("PlayerTwoHand")){
                    playerClient.setPlayerTwoHandCards(messagefromServer.substring(13));
                }else if(messagefromServer.substring(0,18).equals("PathTileGameBoard_")){
                    playerClient.setGameBoard(messagefromServer.substring(18));
                }else if(messagefromServer.substring(0,17).equals("Player1_Position_")){
                    definePawnPosition.setPosition(messagefromServer);
                    playerClient.sendMessageToServer("GetPlayerOneHand");
                    playerClient.sendMessageToServer("GetPlayerOneHandTiles");
                    playerClient.sendMessageToServer("ReturnGameBoard");
                }else if(messagefromServer.substring(0,15).equals("PlayerOnePTHand")){
                    // Wird benötigt falls die Hand Leer ist.
                    if(messagefromServer.equals("PlayerOnePTHand")){}else {
                        playerClient.setPlayerOneHandTiles(messagefromServer.substring(15));
                    }
                }else if(messagefromServer.substring(0,15).equals("PlayerTwoPTHand")){
                    // Wird benötigt falls die Hand Leer ist.
                    if(messagefromServer.equals("PlayerTwoPTHand")){}else {
                        playerClient.setPlayerTwoHandTiles(messagefromServer.substring(15));
                    }
                }
        }

        return null;
    }

}
