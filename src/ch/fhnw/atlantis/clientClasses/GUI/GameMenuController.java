package ch.fhnw.atlantis.clientClasses.GUI;

/**
 * Created by Nadine on 08.11.2016.
 */
import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.util.Duration;


public class GameMenuController {
    // Model
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



/** private GameMenuView gameMenu_view;
 private Stage GameMenu_stage;

 public GameMenuController(GameMenuView gameMenu_view, Stage gameMenu_stage){

 GameMenuView gameMenu_view1 = new GameMenuView();
 this.gameMenu_view = gameMenu_view1;
 gameMenu_view1.show(gameMenu_stage);
 }
 }
 */
