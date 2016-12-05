package ch.fhnw.atlantis.clientClasses.GUI;

import ch.fhnw.atlantis.globalClasses.models.GameBoard;

/**
 * Created by js on 02.11.2016.
 */
public class GameBoardController {

    public Model model;
    public GameBoardView view;

    public GameBoardController(Model model){
        super();
        this.model = model;
        this.view = new GameBoardView();

    }

    public void show() {
        view.show(model.getPrimaryStage());

    }

}
