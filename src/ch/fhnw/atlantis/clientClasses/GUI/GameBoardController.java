package ch.fhnw.atlantis.clientClasses.GUI;

/**
 * Created by js on 02.11.2016.
 */
public class GameBoardController {

    public GameBoardModel model;
    public GameBoardView view;

    public GameBoardController(GameBoardModel model, GameBoardView view){
        super();
        this.model = model;
        this.view = view;

    }


}
