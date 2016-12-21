package ch.fhnw.atlantis.clientClasses.GUI;

import java.io.FileNotFoundException;

/**
 * Created by Richard on 19/12/2016.
 */
public class DefinePawnPosition {

    public void setPosition(String Message) throws FileNotFoundException {

        GameBoardView gameBoardView = new GameBoardView();
        String Position = Message.substring(8);
        int PositionX = 0;
        int PositionY = 0;

        switch (Position) {
            case "Position_0":
                PositionX = 1;
                PositionY = 3;
                break;
            case "Position_1":
                PositionX = 1;
                PositionY = 4;
                break;
            case "Position_2":
                PositionX = 1;
                PositionY = 5;
                break;
            case "Position_3":
                PositionX = 2;
                PositionY = 6;
                break;
            case "Position_4":
                PositionX = 3;
                PositionY = 6;
                break;
            case "Position_5":
                PositionX = 4;
                PositionY = 5;
                break;
            case "Position_6":
                PositionX = 4;
                PositionY = 4;
                break;
            case "Position_7":
                PositionX = 4;
                PositionY = 3;
                break;
            case "Position_8":
                PositionX = 4;
                PositionY = 2;
                break;
            case "Position_9":
                PositionX = 5;
                PositionY = 1;
                break;
            case "Position_10":
                PositionX = 6;
                PositionY = 2;
                break;
            case "Position_11":
                PositionX = 6;
                PositionY = 3;
                break;
            case "Position_12":
                PositionX = 7;
                PositionY = 4;
                break;
            case "Position_13":
                PositionX = 8;
                PositionY = 3;
                break;
            case "Position_14":
                PositionX = 8;
                PositionY = 2;
                break;
            case "Position_15":
                PositionX = 9;
                PositionY = 1;
                break;
            case "Position_16":
                PositionX = 10;
                PositionY = 1;
                break;
            case "Position_17":
                PositionX = 11;
                PositionY = 1;
                break;
            case "Position_18":
                PositionX = 12;
                PositionY = 1;
                break;
            case "Position_19":
                PositionX = 13;
                PositionY = 1;
                break;
            case "Position_20":
                PositionX = 14;
                PositionY = 2;
                break;
            case "Position_21":
                PositionX = 14;
                PositionY = 3;
                break;
            case "Position_22":
                PositionX = 14;
                PositionY = 4;
                break;
            case "Position_23":
                PositionX = 14;
                PositionY = 5;
                break;
            case "Position_24":
                PositionX = 14;
                PositionY = 6;
                break;
            case "Position_98":
                // Zurück an Start für nächsten Pawn
                PositionX = 1;
                PositionY = 0;
                break;
        }


        if (Message.substring(0,7).equals("Player1")){
            gameBoardView.setPositionPawnP1(PositionX, PositionY);
        }
        if (Message.substring(0,7).equals("Player2")){
            gameBoardView.setPositionPawnP2(PositionX, PositionY);
        }
    }

}
