package ch.fhnw.atlantis.clientClasses.GUI;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

import java.util.Optional;

/**
 * Created by Nadine on 18.10.2016.
 * MVC - Vorlage zur Strukturierung von Programmen, notwendig um
 * Programme schnell erweitern zu können und sich schnell einarbeiten - schneller Fehler finden
 * Mehrere Views (alles was angezeigt wird) mit mehreren Controller (kümmert sich um Interaktion)und einem Model (Datenablage wie Listen/Werte)
 *
 */

public class LogInController {
    private Model model;
    private LogInView view;

    public LogInController(Model model) {
        this.model = model;
        this.view = new LogInView();


        view.getBtnConnect().setOnAction(new btnConnectEventHandler());
        view.getBtnClose().setOnAction(new btnCloseEventHandler());

        // ------------------- CSS Styling den Playern (Icons) zuweisen - WEISS -------------------
        view.getPlayer1().getStyleClass().add("Playerbefore");
        view.getPlayer2().getStyleClass().add("Playerbefore");
        view.getPlayer3().getStyleClass().add("Playerbefore");
        view.getPlayer4().getStyleClass().add("Playerbefore");

    }

    public void show() {
        view.show(model.getPrimaryStage());

    }

    class btnCloseEventHandler implements EventHandler<ActionEvent>{
        @Override
        public void handle(ActionEvent event) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION,
                    "Soll Atlantis wirklich beendet werden?", ButtonType.YES, ButtonType.NO);
            alert.setTitle("Confirmation Dialog");
            alert.setHeaderText("Spiel verlassen");

            Optional<ButtonType> result = alert.showAndWait();
            if (result.get()== ButtonType.YES){
                System.out.println("Atlantis verlassen");
                System.exit(0);
            }
        }
    }


    class btnConnectEventHandler implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event) {
            MenuController menuController = new MenuController(model);
            menuController.show();
        }
    }
}
