package ch.fhnw.atlantis.clientClasses.GUI;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/**
 * Created by Nadine on 18.10.2016.
 * MVC - Vorlage zur Strukturierung von Programmen, notwendig um
 * Programme schnell erweitern zu können und sich schnell einarbeiten - schneller Fehler finden
 * Mehrere Views (alles was angezeigt wird) mit mehreren Controller (kümmert sich um Interaktion)und einem Model (Datenablage wie Listen/Werte)
 *
 */

public class WelcomeController {
    private Model model;
    private WelcomeView view;

    public WelcomeController(Model model){
        this.model = model;
        this.view = new WelcomeView();

        view.getBtnConnect().setOnAction(new btnConnectEventHandler());
    }

        public void show(){
        view.show(model.getPrimaryStage());

    }

    class btnConnectEventHandler implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event) {
            GameMenuController gameMenuController = new GameMenuController(model);
            gameMenuController.show();

        }
    }
}
