package ch.fhnw.atlantis.clientClasses.GUI;

import java.io.FileNotFoundException;

/**
 * @author Juerg
 */
public class GameBoardController {

    private PlayerClient playerClient;
    public Model model;
    public GameBoardView view;

    public GameBoardController(Model model) throws FileNotFoundException {
        super();
        this.model = model;
        this.view = new GameBoardView();
        playerClient = PlayerClient.getInstance();

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
            playerClient.closeMyTurn();
        });

        view.getBtnNextCard().setOnAction(event -> {
            view.UpdatePositiveMovementCard();
        });

        view.getBtnNextTile().setOnAction(event -> {
            view.UpdatePositivePathTile();
        });

        view.getBtnPlayCard().setOnAction(event -> {
            view.playMovementCard();
            // MovementCardPlayed darf einfach nicht mehr dem PlayersTurn entsprechen
            playerClient.MovementCardPlayed++;
        });

        // Das ist der Plättchen eintauschen Button
        view.getBtnPlayTile().setOnAction(event -> {
            view.sendPathTileExchange();
            playerClient.PathTileExchanged++;

        });

        // ------------------- CSS Styling der Gameboard Elemente  -------------------

        view.getPlayer1().getStyleClass().add("Pawn-P1");
        view.getPlayer2().getStyleClass().add("Pawn-P2");
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


    public void getBtnPlayCard(){
        view.playMovementCard();
    }

    //Show Methode der GameBoard Klase
    public void show() {
        view.show(model.getPrimaryStage());
    }

}
