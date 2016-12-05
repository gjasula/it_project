package ch.fhnw.atlantis.globalClasses.models;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;

import java.io.Serializable;
import java.util.Hashtable;

/**
 * Created by juerg on 02.12.2016.
 *
 * Klasse für die Erstellung von Karten sowie die Bewegung derjenigen
 */

enum TileType {
    TILE, WATER, START, END, BRIDGE, MOVEMENT;
}

public class Card extends Rectangle implements Serializable {

    //private static final long serialVersionUID = 1;

    public boolean isOnTop;
    private boolean isPlayed;
    private int value, colorSet, pathID;
    private TileType object;
    private Image image;

    public final static Color Blue = Color.BLUE;
    public final static Color Brown = Color.BROWN;
    public final static Color Green = Color.GREEN;
    public final static Color Gray = Color.GRAY;
    public final static Color Pink = Color.PINK;
    public final static Color Yellow = Color.YELLOW;
    public final static Color White = Color.WHITE;


    /**
     * Erstelle eine Hashtable mit ImageView Objekten auf Enums der einzelnen Tiles
     * sowie der einzelnen Karten
     * Inkl. Start und Ende des Spiels
     * @param htOfImages
     */
    public void addImagesToTile(Hashtable<String, ImageView> htOfImages) {

        if (this.getObject() == TileType.TILE) {
            //TODO: müssen wir noch für unsere Zwecke anpassen mit den Bildernamen
            super.setFill(new ImagePattern(htOfImages.get(colorSet + "_" + value + ".jpg").getImage()));

        } else if (getObject() == TileType.MOVEMENT) {

            super.setFill(new ImagePattern(htOfImages.get("card_" + colorSet + ".jpg").getImage()));

        } else if (getObject() == TileType.START) {

            super.setFill(new ImagePattern(htOfImages.get("atlantis.jpg").getImage()));

        } else if (getObject() == TileType.END) {

            super.setFill(new ImagePattern(htOfImages.get("land.jpg").getImage()));
        }
    }

    /** Getter und Setter für die definierten Attribute*/

    public TileType getObject() {
        return object;
    }

    public boolean isPlayed() {
        return isPlayed;
    }

    public void setPlayed(boolean played) {
        isPlayed = played;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getColorSet() {
        return colorSet;
    }

    public void setColorSet(int colorSet) {
        this.colorSet = colorSet;
    }

    public void setObject(TileType object) {
        this.object = object;
    }

    public int getPathID() {
        return pathID;
    }

    public void setPathID(int pathID) {
        this.pathID = pathID;
    }

    public boolean isOnTop() {
        return isOnTop;
    }


    public void setImage(Image image) {
        this.image = image;
    }
}



