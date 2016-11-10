package ch.fhnw.atlantis.globalClasses.models;

/**
 * Created by js on 22.10.2016.
 */
public enum Tile {
    PT_Blue_1(1, 1, "Blau 1", "blue_1.jpg"),
    PT_Blue_2(2, 2, "Blau 2", "blue_2.jpg"),
    PT_Blue_3(3, 3, "Name Bild", "blue_3.png"),
    PT_Blue_4(4, 4, "Name Bild", "blue_4.png"),
    PT_Blue_5(5, 5, "Name Bild", "blue_5.png"),
    PT_Blue_6(6, 6, "Name Bild", "blue_6.png"),
    PT_Blue_7(7, 7, "Name Bild", "blue_7.png"),

    PT_Brown_1(8, 1, "Name Bild", "brown_1.png"),
    PT_Brown_2(9, 2, "Name Bild", "brown_2.png"),
    PT_Brown_3(10, 3, "Name Bild", "brown_3.png"),
    PT_Brown_4(11, 4, "Name Bild", "brown_4.png"),
    PT_Brown_5(12, 5, "Name Bild", "brown_5.png"),
    PT_Brown_6(13, 6, "Name Bild", "brown_6.png"),
    PT_Brown_7(14, 7, "Name Bild", "brown_7.png"),

    PT_Green_1(15, 1, "Name Bild", "green_1.png"),
    PT_Green_2(16, 2, "Name Bild", "green_2.png"),
    PT_Green_3(17, 3, "Name Bild", "green_3.png"),
    PT_Green_4(18, 4, "Name Bild", "green_4.png"),
    PT_Green_5(19, 5, "Name Bild", "green_5.png"),
    PT_Green_6(20, 6, "Name Bild", "green_6.png"),
    PT_Green_7(21, 7, "Name Bild", "green_7.png"),

    PT_Grey_1(22, 1, "Name Bild", "grey_1.png"),
    PT_Grey_2(23, 2, "Name Bild", "grey_2.png"),
    PT_Grey_3(24, 3, "Name Bild", "grey_3.png"),
    PT_Grey_4(25, 4, "Name Bild", "grey_4.png"),
    PT_Grey_5(26, 5, "Name Bild", "grey_5.png"),
    PT_Grey_6(27, 6, "Name Bild", "grey_6.png"),
    PT_Grey_7(28, 7, "Name Bild", "grey_7.png"),

    PT_Pink_1(29, 1, "Name Bild", "pink_1.png"),
    PT_Pink_2(30, 2, "Name Bild", "pink_2.png"),
    PT_Pink_3(31, 3, "Name Bild", "pink_3.png"),
    PT_Pink_4(32, 4, "Name Bild", "pink_4.png"),
    PT_Pink_5(33, 5, "Name Bild", "pink_5.png"),
    PT_Pink_6(34, 6, "Name Bild", "pink_6.png"),
    PT_Pink_7(35, 7, "Name Bild", "pink_7.png"),

    PT_White_1(36, 1, "Name Bild", "white_1.png"),
    PT_White_2(37, 2, "Name Bild", "white_2.png"),
    PT_White_3(38, 3, "Name Bild", "white_3.png"),
    PT_White_4(39, 4, "Name Bild", "white_4.png"),
    PT_White_5(40, 5, "Name Bild", "white_5.png"),
    PT_White_6(41, 6, "Name Bild", "white_6.png"),
    PT_White_7(42, 7, "Name Bild", "white_7.png"),

    PT_Yellow_1(43, 1, "Name Bild", "yellow_1.png"),
    PT_Yellow_2(44, 2, "Name Bild", "yellow_2.png"),
    PT_Yellow_3(47, 3, "Name Bild", "yellow_3.png"),
    PT_Yellow_4(48, 4, "Name Bild", "yellow_4.png"),
    PT_Yellow_5(49, 5, "Name Bild", "yellow_5.png"),
    PT_Yellow_6(50, 6, "Name Bild", "yellow_6.png"),
    PT_Yellow_7(51, 7, "Name Bild", "yellow_7.png");

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





