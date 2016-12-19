package ch.fhnw.atlantis.clientClasses.GUI;

import ch.fhnw.atlantis.globalClasses.models.GameBoard;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import java.io.FileNotFoundException;

/**
 * Created by js on 02.11.2016.
 */
public class GameBoardController {

    public Model model;
    public GameBoardView view;

    public GameBoardController(Model model) throws FileNotFoundException {
        super();
        this.model = model;
        this.view = new GameBoardView();

        // Eventhandler für Buttons auf dem GameBoard

        view.getBtnBuyCard().setOnAction(event -> {
            view.btnPlayTile.setDisable(false);
            view.btnPlayCard.setDisable(false);
            view.btnNextTile.setDisable(false);
            view.btnNextCard.setDisable(false);
            view.btnFinishTurn.setDisable(false);
            view.btnBuyCard.setDisable(true);
            view.UpdateGUIThread();
        });

        view.getBtnFinishTurn().setOnAction(event -> {
        });

        view.getBtnNextCard().setOnAction(event -> {
            view.UpdatePositiveMovementCard();
        });

        view.getBtnNextTile().setOnAction(event -> {
            view.UpdatePositivePathTile();
        });

        view.getBtnPlayCard().setOnAction(event -> {

        });

        view.getBtnPlayTile().setOnAction(event -> {
            // Das ist Plättchen eintauschen
            view.sendPathTileExchange();
        });

        // ------------------- CSS Styling der Gameboard Elemente  -------------------

        view.getPlayer1().getStyleClass().add("Playerbefore");
        view.getPlayer2().getStyleClass().add("Playerbefore");
        view.getPlayer3().getStyleClass().add("Playerbefore");
        view.getPlayer4().getStyleClass().add("Playerbefore");

        view.getPointsP1().getStyleClass().add("Label-big");
        view.getPointsP2().getStyleClass().add("Label-big");
        view.getPointsP3().getStyleClass().add("Label-big");
        view.getPointsP4().getStyleClass().add("Label-big");

        view.getPawnP1().getStyleClass().add("Pawn-P1");
        view.getPawnP2().getStyleClass().add("Pawn-P2");
        view.getPawnP3().getStyleClass().add("Pawn-P3");
        view.getPawnP4().getStyleClass().add("Pawn-P4");
    }

    //Show Methode der GameBoard Klase

    public void show() {
        view.show(model.getPrimaryStage());
    }

}
