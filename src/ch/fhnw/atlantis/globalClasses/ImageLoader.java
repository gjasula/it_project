package ch.fhnw.atlantis.globalClasses;

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

    public static Image getPathTile() throws FileNotFoundException {

        String imagePath = "ch/fhnw/atlantis/resources/images/";
        TileDeck tileDeck = new TileDeck();

        try {
            return new Image(imagePath + tileDeck.getTileImage());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }

}
