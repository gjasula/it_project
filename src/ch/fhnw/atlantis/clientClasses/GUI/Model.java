package ch.fhnw.atlantis.clientClasses.GUI;

import ch.fhnw.atlantis.globalClasses.*;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import java.util.ArrayList;
import java.util.Hashtable;

/**
 * Created by Nadine on 03.11.2016.
 * ch.fhnw.atlantis.clientClasses.GUI.Model: speichert die wichtigen Elemente des Programms
 *
 * PrimaryStage ist das Hauptanwendungsfenster -
 * braucht es um versch. Views anzuzeigen (damit Fenster nicht immer auf und zu geht merkt sich Programm "PrimaryStage")
 * PrimaryStage intern werden die Views durch neue Views ersetzt.
 */

public class Model {
    private Stage primaryStage = null;

    private TileDeck tileDeck;

    public Model(Stage primaryStage){

        tileDeck = new TileDeck();

        this.primaryStage = primaryStage;
    }

    // Getter and Setter
    public Stage getPrimaryStage(){
        return primaryStage;
    }
}


