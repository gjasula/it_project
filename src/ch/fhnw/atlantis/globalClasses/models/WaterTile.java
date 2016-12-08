package ch.fhnw.atlantis.globalClasses.models;

/**
 * Created by juerg on 07.12.2016.
 */
public class WaterTile {

    private boolean onBoard;
    private boolean isWater;
    private int price;

    public WaterTile() {
        this.onBoard = false;
        this.isWater = true;
        this.price = price;
    }

    public boolean isOnBoard() {
        return onBoard;
    }

    public void setOnBoard(boolean onBoard) {
        this.onBoard = onBoard;
    }

    public boolean isWater() {
        return isWater;
    }

    public void setWater(boolean water) {
        isWater = water;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
