package ch.fhnw.atlantis.clientClasses.GUI;

import javafx.scene.image.Image;

import java.io.FileNotFoundException;

/**
 * @author Juerg
 */
public class ImageLoader {
    private PlayerClient playerClient;

    public ImageLoader() {
        playerClient = PlayerClient.getInstance();
    }

    public static Image getImage(String imageName) throws FileNotFoundException {

        String imagePath = "ch/fhnw/atlantis/resources/images/";

        try {
            return new Image(imagePath + imageName);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }

    public Image getPathTile(int PathTileNumber) {

        String imagePath = "ch/fhnw/atlantis/resources/images/";
        String imageName = "water.jpg";
        imageName = playerClient.getTileImage(PathTileNumber);

        try {
            return new Image(imagePath + imageName);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }

    public Image getPlayerMovementCardHand(int MovementCardNumber){
        String imagePath = "ch/fhnw/atlantis/resources/images/";
        String imageName = "water.jpg";
        ConvertMovementCardToFileName convertMovementCardToFileName = new ConvertMovementCardToFileName();

        imageName = convertMovementCardToFileName.ConvertMovementCardToFileName(playerClient.getPlayerMovementCardHandGUI(MovementCardNumber));

        try {
            return new Image(imagePath + imageName);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public Image getPlayerPathTileHand(int PathTileNumber){
        String imagePath = "ch/fhnw/atlantis/resources/images/";
        String imageName = "water.jpg";

        imageName = playerClient.getPlayerPathTileHandGUI(PathTileNumber);

        try {
            return new Image(imagePath + imageName);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
