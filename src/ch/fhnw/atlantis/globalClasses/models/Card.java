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


public class Card extends Rectangle implements Serializable {

    //private static final long serialVersionUID = 1;

    public boolean isOnTop;
    private boolean isPlayed;
    private int value, colorSet, pathID;
    private Card object;
    private Image image;



    /** Getter und Setter für die definierten Attribute*/



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



