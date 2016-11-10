package ch.fhnw.atlantis.clientClasses.GUI;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/**
 * Created by Nadine on 18.10.2016.
 * MVC - Vorlage zur Strukturierung von Programmen, notwendig um
 * Programme schnell erweitern zu können und sich schnell einarbeiten - schneller Fehler finden
 * Mehrere Views (alles was angezeigt wird) mit mehreren Controller (kümmert sich um Interaktion)und einem ch.fhnw.atlantis.clientClasses.GUI.Model (Datenablage wie Listen/Werte)
 *
 */

public class WelcomeController {
    // ch.fhnw.atlantis.clientClasses.GUI.Model
    private Model model;
    // View
    private WelcomeView view;

    // Konstruktor sichert ch.fhnw.atlantis.clientClasses.GUI.Model und erstellt View
    public WelcomeController(Model model) {
        this.model = model;
        this.view = new WelcomeView();

        //Eventhandler initialisieren - damit ausgeführt werden kann
        view.getBtnConnect().setOnAction(new btnConnectEventHandler());
    }

    public void show() {
        view.show(model.getPrimaryStage());

    }

    // Klassen erstellen für Eventhandler

    class btnConnectEventHandler implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent e) {
            GameMenuController gameMenucontroller = new GameMenuController(model);
            gameMenucontroller.show();

        }
    }
}






