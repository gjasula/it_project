package ch.fhnw.atlantis.clientClasses.GUI;

import ch.fhnw.atlantis.clientClasses.GUI.ConvertMovementCardToFileName;
import ch.fhnw.atlantis.clientClasses.GUI.PlayerClient;
import ch.fhnw.atlantis.globalClasses.models.TileDeck;
import javafx.scene.image.Image;

import java.io.FileNotFoundException;

/**
 * Created by js on 13.11.2016.
 */
public class ImageLoader {

    public static Image getImage(String imageName) throws FileNotFoundException {

        String imagePath = "ch/fhnw/atlantis/resources/images/";

        //File f = new File(imagePath + imageName);
        //if (!f.exists()) {
        //throw new FileNotFoundException(imagePath + imageName + " wasn't found.");
        //}
        try {
            return new Image(imagePath + imageName);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }

    public static Image getPathTile(int PathTileNumber) throws FileNotFoundException {

        String imagePath = "ch/fhnw/atlantis/resources/images/";
        String imageName = "water.jpg";
        PlayerClient playerClient = new PlayerClient();

        imageName = playerClient.getTileImage(PathTileNumber);

        try {
            return new Image(imagePath + imageName);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }

    public static Image getPlayerMovementCardHand(int MovementCardNumber){
        String imagePath = "ch/fhnw/atlantis/resources/images/";
        String imageName = "water.jpg";
        PlayerClient playerClient = new PlayerClient();
        ConvertMovementCardToFileName convertMovementCardToFileName = new ConvertMovementCardToFileName();

        imageName = convertMovementCardToFileName.ConvertMovementCardToFileName(playerClient.getPlayerMovementCardHandGUI(MovementCardNumber));

        try {
            return new Image(imagePath + imageName);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Image getPlayerPathTileHand(int PathTileNumber){
        String imagePath = "ch/fhnw/atlantis/resources/images/";
        String imageName = "water.jpg";
        PlayerClient playerClient = new PlayerClient();

        imageName = playerClient.getPlayerPathTileHandGUI(PathTileNumber);

        try {
            return new Image(imagePath + imageName);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
