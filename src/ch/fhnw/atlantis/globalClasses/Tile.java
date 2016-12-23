package ch.fhnw.atlantis.globalClasses;

import javafx.scene.layout.StackPane;

import java.io.Serializable;

/**
 * @author juerg
 * <p>
 * Klasse zur Erstellung von Bewegungsplättchen und Zuteilung auf dem Spielfeld
 */

public class Tile extends StackPane implements Serializable {

    private static final long serialVersionUID = 1;

    private Color color;
    private int tileNumber;
    private int tileValue;
    private boolean tileInGame;
    private boolean isWater;

    //Constructor for regular tile
    public Tile(int tileValue, Color color) {
        this.color = color;
        this.tileValue = tileValue;
        tileInGame = true;
        isWater = false;
    }

    //Constructor for watertile
    public Tile(boolean isWater) {
        this.isWater = isWater;
    }

    /** Getter and Setter */

    public int getTileNumber() {
        return tileNumber;
    }

    public void setTileNumber(int tileNumber) {
        this.tileNumber = tileNumber;
    }

    public int getTileValue() {
        return tileValue;
    }

    public void setTileValue(int tileValue) {
        this.tileValue = tileValue;
    }

    public boolean isTileInGame() {
        return tileInGame;
    }

    public void setTileInGame(boolean tileInGame) {
        this.tileInGame = tileInGame;
    }

    public boolean isWater() {
        return isWater;
    }

    public void setWater(boolean water) {
        isWater = water;
    }
}