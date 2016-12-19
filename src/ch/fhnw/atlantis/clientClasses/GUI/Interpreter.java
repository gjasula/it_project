package ch.fhnw.atlantis.clientClasses.GUI;

/**
 * Created by Richard on 10/12/2016.
 */
public class Interpreter {

    PlayerClient playerClient = new PlayerClient();

    public String interpretClientMsg(String messagefromServer){

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
            default:

                if(messagefromServer.substring(0,13).equals("PlayerOneHand")){
                    playerClient.setPlayerOneHandCards(messagefromServer.substring(13));
                }else if(messagefromServer.substring(0,13).equals("PlayerTwoHand")){
                    playerClient.setPlayerTwoHandCards(messagefromServer.substring(13));
                }else if(messagefromServer.substring(0,18).equals("PathTileGameBoard_")){
                    playerClient.setGameBoard(messagefromServer.substring(18));
                }
        }

        return null;
    }

}
