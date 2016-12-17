package ch.fhnw.atlantis.clientClasses.GUI;

import ch.fhnw.atlantis.globalClasses.models.GameBoard;

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

        // ------------------- CSS Styling den Playern (Icons) zuweisen - WEISS -------------------
        view.getPlayer1().getStyleClass().add("Playerbefore");
        view.getPlayer2().getStyleClass().add("Playerbefore");
        view.getPlayer3().getStyleClass().add("Playerbefore");
        view.getPlayer4().getStyleClass().add("Playerbefore");

        view.getPointsP1().getStyleClass().add("Label-big");
        view.getPointsP2().getStyleClass().add("Label-big");
        view.getPointsP3().getStyleClass().add("Label-big");
        view.getPointsP4().getStyleClass().add("Label-big");

        view.getPawnP1().getStyleClass().add("PawnP1");



    }

    public void show() {
        view.show(model.getPrimaryStage());

    }

}
