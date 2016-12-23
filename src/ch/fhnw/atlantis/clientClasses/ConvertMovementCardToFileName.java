package ch.fhnw.atlantis.clientClasses;

/**
 * @author Richard
 * Diese Klasse wandelt z.B. MV_Blue in card_Blue.jpg um.
 * Sie wird im ImageLoader verwendet um die Hand vom Spieler in Bilder umzwandeln damit diese dargestellt werden können.
 */
public class ConvertMovementCardToFileName {

    public String ConvertMovementCardToFileName(String MovementCardName) {

        String Filename = null;

        switch (MovementCardName) {
            case "MV_Blue":
                Filename = "card_Blue.jpg";
                break;
            case "MV_Brown":
                Filename = "card_Brown.jpg";
                break;
            case "MV_Green":
                Filename = "card_Green.jpg";
                break;
            case "MV_Grey":
                Filename = "card_Grey.jpg";
                break;
            case "MV_Pink":
                Filename = "card_Pink.jpg";
                break;
            case "MV_White":
                Filename = "card_White.jpg";
                break;
            case "MV_Yellow":
                Filename = "card_Yellow.jpg";
                break;
            default:
        }

        return Filename;
    }

}
