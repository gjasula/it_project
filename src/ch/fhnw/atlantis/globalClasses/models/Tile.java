package ch.fhnw.atlantis.globalClasses.models;

/**
 * Created by js on 22.10.2016.
 */
public enum Tile {
    PT_Blue_1(1, 1, "Blue 1", "blue_1.jpg"),
    PT_Blue_2(2, 2, "Blue 2", "blue_2.jpg"),
    PT_Blue_3(3, 3, "Blue 3", "blue_3.jpg"),
    PT_Blue_4(4, 4, "Blue 4", "blue_4.jpg"),
    PT_Blue_5(5, 5, "Blue 5", "blue_5.jpg"),
    PT_Blue_6(6, 6, "Blue 6", "blue_6.jpg"),
    PT_Blue_7(7, 7, "Blue 7", "blue_7.jpg"),

    PT_Brown_1(8, 1, "Brown 1", "brown_1.jpg"),
    PT_Brown_2(9, 2, "Brown 2", "brown_2.jpg"),
    PT_Brown_3(10, 3, "Brown 3", "brown_3.jpg"),
    PT_Brown_4(11, 4, "Brown 4", "brown_4.jpg"),
    PT_Brown_5(12, 5, "Brown 5", "brown_5.jpg"),
    PT_Brown_6(13, 6, "Brown 6", "brown_6.jpg"),
    PT_Brown_7(14, 7, "Brown 7", "brown_7.jpg"),

    PT_Green_1(15, 1, "Green 1", "green_1.jpg"),
    PT_Green_2(16, 2, "Green 2", "green_2.jpg"),
    PT_Green_3(17, 3, "Green 3", "green_3.jpg"),
    PT_Green_4(18, 4, "Green 4", "green_4.jpg"),
    PT_Green_5(19, 5, "Green 5", "green_5.jpg"),
    PT_Green_6(20, 6, "Green 6", "green_6.jpg"),
    PT_Green_7(21, 7, "Green 7", "green_7.jpg"),

    PT_Grey_1(22, 1, "Grey 1", "grey_1.jpg"),
    PT_Grey_2(23, 2, "Grey 2", "grey_2.jpg"),
    PT_Grey_3(24, 3, "Grey 3", "grey_3.jpg"),
    PT_Grey_4(25, 4, "Grey 4", "grey_4.jpg"),
    PT_Grey_5(26, 5, "Grey 5", "grey_5.jpg"),
    PT_Grey_6(27, 6, "Grey 6", "grey_6.jpg"),
    PT_Grey_7(28, 7, "Grey 7", "grey_7.jpg"),

    PT_Pink_1(29, 1, "Pink 1", "pink_1.jpg"),
    PT_Pink_2(30, 2, "Pink 2", "pink_2.jpg"),
    PT_Pink_3(31, 3, "Pink 3", "pink_3.jpg"),
    PT_Pink_4(32, 4, "Pink 4", "pink_4.jpg"),
    PT_Pink_5(33, 5, "Pink 5", "pink_5.jpg"),
    PT_Pink_6(34, 6, "Pink 6", "pink_6.jpg"),
    PT_Pink_7(35, 7, "Pink 7", "pink_7.jpg"),

    PT_White_1(36, 1, "White 1", "white_1.jpg"),
    PT_White_2(37, 2, "White 2", "white_2.jpg"),
    PT_White_3(38, 3, "White 3", "white_3.jpg"),
    PT_White_4(39, 4, "White 4", "white_4.jpg"),
    PT_White_5(40, 5, "White 5", "white_5.jpg"),
    PT_White_6(41, 6, "White 6", "white_6.jpg"),
    PT_White_7(42, 7, "White 7", "white_7.jpg"),

    PT_Yellow_1(43, 1, "Yellow 1", "yellow_1.jpg"),
    PT_Yellow_2(44, 2, "Yellow 2", "yellow_2.jpg"),
    PT_Yellow_3(47, 3, "Yellow 3", "yellow_3.jpg"),
    PT_Yellow_4(48, 4, "Yellow 4", "yellow_4.jpg"),
    PT_Yellow_5(49, 5, "Yellow 5", "yellow_5.jpg"),
    PT_Yellow_6(50, 6, "Yellow 6", "yellow_6.jpg"),
    PT_Yellow_7(51, 7, "Yellow 7", "yellow_7.jpg");

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
     * */

    @Override
    public String toString() {
        return this.name;
    }
};





