package ch.fhnw.atlantis.globalClasses.models;

import javafx.scene.layout.StackPane;
import javafx.scene.paint.*;

import java.awt.*;
import java.io.Serializable;

/**
 * Created by juerg on 02.12.2016.
 *
 * Klasse zur Erstellung von Bewegungsplättchen und Zuteilung auf dem Spielfeld
 */

public class Tile extends StackPane implements Serializable {

    //private static final long serialVersionUID = 1;

    private int tileValue;
    private int posX;
    private int posY;
    private boolean tileInGame;
    private boolean isWater;

    private Color color;

    // Constructor for pathtile
    public Tile(int tileValue, Color color) {
        this.color = color;
        this.tileValue = tileValue;
        this.isWater = false;
    }

    // Constructor for watertile
    public Tile(boolean isWater) {
        this.isWater = isWater;
    }

    /** Getter and Setter */

    public int getTileValue() {
        return tileValue;
    }

    public void setTileValue(int tileValue) {
        this.tileValue = tileValue;
    }

    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
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

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}