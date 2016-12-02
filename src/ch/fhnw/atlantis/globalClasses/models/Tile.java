package ch.fhnw.atlantis.globalClasses.models;

import javafx.scene.layout.StackPane;

import java.io.Serializable;

/**
 * Created by juerg on 02.12.2016.
 *
 * Klasse zur Erstellung von Bewegungsplättchen und Zuteilung auf dem Spielfeld
 */

public class Tile extends StackPane implements Serializable {

    //private static final long serialVersionUID = 1;

    private int pathId;
    private int x;
    private int y;
    private int side;


    public Tile(int x, int y, int pathId) {
        this.x = x;
        this.y = y;
        this.pathId = pathId;
    }

    /** Getter and Setter */

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getSide() {
        return side;
    }

    public void setSide(int side) {
        this.side = side;
    }

    public int getPathId() {
        return pathId;
    }

    public void setPathId(int pathId) {
        this.pathId = pathId;
    }
}