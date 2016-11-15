package ch.fhnw.atlantis.clientClasses.GUI;


/**
 * Created by Nadine on 25.10.2016.
 */

public class GameMenuController {
    private Model model;
    private GameMenuView view;

    public  GameMenuController(Model model){
        this.model = model;
        this.view = new GameMenuView();


    }

    public void show(){
        view.show(model.getPrimaryStage());
    }

}

