package ch.fhnw.atlantis.clientClasses.GUI;

/**
 * Created by Nadine on 25.10.2016.
 */

public class GameMenuController {
    // ch.fhnw.atlantis.clientClasses.GUI.Model
    private Model model;
    // View
    private GameMenuView view;

    public GameMenuController(Model model){
        this.model = model;
        this.view = new GameMenuView();

     // Eventhandler registrieren


    }

    public void show(){
        view.show(model.getPrimaryStage());
    }

    }



   /** private ch.fhnw.atlantis.clientClasses.GUI.GameMenuView gameMenu_view;
    private Stage GameMenu_stage;

    public ch.fhnw.atlantis.clientClasses.GUI.GameMenuController(ch.fhnw.atlantis.clientClasses.GUI.GameMenuView gameMenu_view, Stage gameMenu_stage){

        ch.fhnw.atlantis.clientClasses.GUI.GameMenuView gameMenu_view1 = new ch.fhnw.atlantis.clientClasses.GUI.GameMenuView();
        this.gameMenu_view = gameMenu_view1;
        gameMenu_view1.show(gameMenu_stage);
    }
}
*/