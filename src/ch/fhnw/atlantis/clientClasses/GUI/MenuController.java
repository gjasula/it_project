package ch.fhnw.atlantis.clientClasses.GUI;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.input.MouseEvent;
import java.io.FileNotFoundException;
import java.util.Optional;

/**
 * @Author Nadine
 */

public class MenuController {
    private PlayerClient playerClient;
    private Model model;
    private MenuView view;

    public MenuController(Model model) {
        this.model = model;
        this.view = new MenuView();
        playerClient = PlayerClient.getInstance();


        // ------------------- Eventhandler registrieren Hauptmenu -------------------
        view.getBtnRules().setOnAction(new btnRulesEventHandler());
        view.getBtnOptions().setOnMouseClicked(new btnOptionsEventHandler1());
        view.getBtnPlayer().setOnMouseClicked(new btnPlayerEventhandler());
        view.getBtnBack().setOnAction(new btnBackEventHandler());
        view.getBtnExit().setOnAction(new btnExitEventHandler());
        view.getBtnStartGame().setOnAction(new btnStartGameEventHandler());

        // ------------------- Eventhandler registrieren Untermenu -------------------

                view.getGameCharacter1().setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        try {
                            GameCharacter1EventHandler();
                        } catch (FileNotFoundException e) {
                            e.printStackTrace();
                        }
                    }
                });
                view.getGameCharacter2().setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        try {
                            GameCharacter2EventHandler();
                        } catch (FileNotFoundException e) {
                            e.printStackTrace();
                        }
                    }
                });
                view.getGameCharacter3().setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        try {
                            GameCharacter3EventHandler();
                        } catch (FileNotFoundException e) {
                            e.printStackTrace();
                        }
                    }
                });
                view.getGameCharacter4().setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        try {
                            GameCharacter4EventHandler();
                        } catch (FileNotFoundException e) {
                            e.printStackTrace();
                        }
                    }
                });

        // ------------------- CSS Styling den angemeldeten Playern (Icons) zuweisen - Orange -------------------
        view.getPlayer1().getStyleClass().add("Playerbefore");
        view.getPlayer2().getStyleClass().add("Playerbefore");
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
    public void GameCharacter1EventHandler() throws FileNotFoundException {
        GameBoardView gameBoardView = new GameBoardView();
        playerClient = PlayerClient.getInstance();

        if(playerClient.PlayerID == 1){
            gameBoardView.setPawnP1("1");
        }else{
            gameBoardView.setPawnP2("1");
        }
    }

    public void GameCharacter2EventHandler() throws FileNotFoundException {
        GameBoardView gameBoardView = new GameBoardView();
        playerClient = PlayerClient.getInstance();

        if(playerClient.PlayerID == 1){
            gameBoardView.setPawnP1("2");
        }else{
            gameBoardView.setPawnP2("2");
        }
    }

    public void GameCharacter3EventHandler() throws FileNotFoundException {
        GameBoardView gameBoardView = new GameBoardView();
        playerClient = PlayerClient.getInstance();

        if(playerClient.PlayerID == 1){
            gameBoardView.setPawnP1("3");
        }else{
            gameBoardView.setPawnP2("3");
        }
    }

    public void GameCharacter4EventHandler() throws FileNotFoundException {
        GameBoardView gameBoardView = new GameBoardView();
        playerClient = PlayerClient.getInstance();
        if(playerClient.PlayerID == 1){
            gameBoardView.setPawnP1("4");
        }else{
            gameBoardView.setPawnP2("4");
        }
    }

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
                Alert information = new Alert(Alert.AlertType.INFORMATION,
                "Wollen Sie die Verbindung zum Server trennen?", ButtonType.YES, ButtonType.NO);
                information.setTitle("Information Dialog");
                information.setHeaderText("Information");
                Optional<ButtonType> result = information.showAndWait();
                if (result.get() == ButtonType.YES) {
                    LogInController logInController = new LogInController(model);
                    logInController.show();
                }
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
    }

        class btnStartGameEventHandler implements EventHandler<ActionEvent> {
            @Override
            public void handle(ActionEvent event) {
              GameBoardController gbCon = null;
                try {
                    gbCon = new GameBoardController(model);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                gbCon.show();
                model.stopMusic();
            }
        }
  }