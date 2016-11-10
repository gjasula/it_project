package ch.fhnw.atlantis.globalClasses.models;

/**
 * Created by js on 22.10.2016.
 */
public enum Tile {
    PT_Blue_1(1, 1, "Blau 1", "blue_1.jpg"),
    PT_Blue_2(2, 2, "Blau 2", "blue_2.jpg");

    int id;
    int value;
    String name;
    String path;

    /**
     * Constructor
     * @param id
     * @param value
     * @param name
     * @param path
     */
     Tile(int id, int value, String name, String path) {
        this.id = id;
        this.value = value;
        this.name = name;
        this.path = path;
    }

    /**
     * Getter and Setter of each attribute
     * @return
     */
    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }



    /**
     * Gibt den Namen des Bewegungplätchens zurück
     * @return Bezeichnung Bewegungsplättchen
     */
    @Override
    public String toString() {
        return this.name;
    }



};





