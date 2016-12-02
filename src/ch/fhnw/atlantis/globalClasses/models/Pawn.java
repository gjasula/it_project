package ch.fhnw.atlantis.globalClasses.models;

import javafx.scene.shape.Rectangle;

import java.io.Serializable;

/**
 * Created by juerg on 02.12.2016.
 *
 * Klasse für die Erstellung von Spielfiguren sowie die Bewegung derjenigen
 */

public class Pawn extends Rectangle implements Serializable {

    //private static final long serialVersionUID = 1;
    private double x;
    private double y;
    private int pathId;

    Player playerPawn;

    public Pawn(Player playerPawn, int pathId) {
        this.playerPawn = playerPawn;
        this.pathId = pathId;
    }

    public void move(double x, double y) {
        this.setLayoutX(x);
        this.setLayoutY(y);
        this.x = x;
        this.y = y;
    }

    public void setPathId(int pathId) {
        this.pathId = pathId;
    }

    public int getPathId() {
        return pathId;
    }

    public double getPawnX() {
        return x;
    }

    public double getPawnY() {
        return y;
    }

}
