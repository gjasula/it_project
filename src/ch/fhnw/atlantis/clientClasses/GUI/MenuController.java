package ch.fhnw.atlantis.clientClasses.GUI;



import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.input.MouseEvent;


import java.io.*;
import java.util.Locale;
import java.util.Optional;
import java.util.Properties;


/**
 * Created by Nadine on 25.10.2016.
 */

public class MenuController {
    private Model model;
    private MenuView view;


    public MenuController(Model model) {
        this.model = model;
        this.view = new MenuView();

        // ------------------- Eventhandler registrieren Hauptmenu -------------------
        view.getBtnRules().setOnAction(new btnRulesEventHandler());
        view.getBtnOptions().setOnMouseClicked(new btnOptionsEventHandler1());
        view.getBtnPlayer().setOnMouseClicked(new btnPlayerEventhandler());
        view.getBtnBack().setOnAction(new btnBackEventHandler());
        view.getBtnExit().setOnAction(new btnExitEventHandler());

        // ------------------- Eventhandler registrieren Untermenu -------------------
     //   view.getBtnSprache1().setOnAction(new btnSprache1Eventhandler());


        // ------------------- StartButton Disable setzen solange, nicht mind. 2 Spieler angemeldet sind -------------------
        view.getBtnStartGame().setDisable(true);

        // solange ProgressIndicator anzeigen: ProgressIndicator pi = new ProgressIndicator();

        // ------------------- CSS Styling den angemeldeten Playern (Icons) zuweisen - Orange -------------------
        view.getPlayer1().getStyleClass().remove("Playerbefore");
        view.getPlayer1().getStyleClass().add("Playerafter");
        view.getPlayer2().getStyleClass().remove("Playerbefore");
        view.getPlayer2().getStyleClass().add("Playerafter");
        view.getPlayer3().getStyleClass().add("Playerbefore");
        view.getPlayer4().getStyleClass().add("Playerbefore");
    }

    // ------------------- View anzeigen - Primarystage aufrufen-------------------
    public void show(){
        view.show(model.getPrimaryStage());
    }

    /* ------------------- EVENTS definieren -------------------
    -------------------------------------------------------------
     ------------------------------------- -------------------*/
    class btnRulesEventHandler implements EventHandler<ActionEvent>{
        @Override
        public void handle(ActionEvent event) {
            RulesController rulesController = new RulesController(model);
            rulesController.show();
        }
    }

     class btnOptionsEventHandler1 implements EventHandler<MouseEvent>{
        @Override
        public void handle(MouseEvent event) {

            view.getBtnSprache1().setVisible(true);
            view.getBtnSprache2().setVisible(true);
            view.getBtnSprache3().setVisible(true);
            view.getIview1().setVisible(true);
            view.getIview2().setVisible(true);
            view.getIview3().setVisible(true);

            view.getGameCharacter1().setVisible(false);
            view.getGameCharacter2().setVisible(false);
            view.getGameCharacter3().setVisible(false);
            view.getGameCharacter4().setVisible(false);
            view.getTxtAtlantis().setVisible(false);

        }
    }

    class btnPlayerEventhandler implements EventHandler<MouseEvent>{
        @Override
        public void handle(MouseEvent event) {

            view.getGameCharacter1().setVisible(true);
            view.getGameCharacter2().setVisible(true);
            view.getGameCharacter3().setVisible(true);
            view.getGameCharacter4().setVisible(true);

            view.getBtnSprache1().setVisible(false);
            view.getBtnSprache2().setVisible(false);
            view.getBtnSprache3().setVisible(false);
            view.getIview1().setVisible(false);
            view.getIview2().setVisible(false);
            view.getIview3().setVisible(false);
            view.getTxtAtlantis().setVisible(false);

        }
    }

    class btnBackEventHandler implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event) {
            LogInController logInController = new LogInController(model);
            logInController.show();

        }
    }

    class btnExitEventHandler implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION,
                    "Soll Atlantis wirklich beendet werden?", ButtonType.YES, ButtonType.NO);
            alert.setTitle("Confirmation Dialog");
            alert.setHeaderText("Spiel verlassen");


            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.YES) {
                System.out.println("Atlantis ist geschlossen");
                System.exit(0);
            }
        }

        class btnSprache1Eventhandler implements EventHandler<ActionEvent> {
            @Override
            public void handle(ActionEvent event) {


            }

        }
    }
}


