package ch.fhnw.atlantis.clientClasses.GUI;

import javafx.stage.Stage;

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

    public Model(Stage primaryStage){
        this.primaryStage = primaryStage;
    }

    public Stage getPrimaryStage(){
        return primaryStage;
    }
}


