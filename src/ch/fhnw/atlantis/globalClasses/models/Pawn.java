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
    private int pawnNum;

    Player playerPawn;

    public Pawn(Player player, int pawnNum) {
        this.pawnNum = pawnNum;

        if (player.getPlayerID() == 1) {

        }
        else {

        }
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

    public int getPawnNum() {
        return pawnNum;
    }

    public void setPawnNum(int pawnNum) {
        this.pawnNum = pawnNum;
    }

    public double getPawnX() {
        return x;
    }

    public double getPawnY() {
        return y;
    }

}
