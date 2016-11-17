package ch.fhnw.atlantis.clientClasses.GUI;


import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.MouseDragEvent;
import javafx.scene.input.MouseEvent;
import javafx.util.Duration;


/**
 * Created by Nadine on 25.10.2016.
 */

public class GameMenuController {
    private Model model;
    private GameMenuView view;


    public  GameMenuController(Model model) {
        this.model = model;
        this.view = new GameMenuView();

        view.getBtnBack().setOnAction(new btnBackEventHandler());
        view.getBtnExit().setOnAction(new btnExitEventHandler());

    //    view.getBtnOptions().setOnMouseClicked(new btnOptionsEventHandler());

        view.getBtnOptions().setOnMouseClicked(event ->{

            }

        });
    }

    public void show(){
        view.show(model.getPrimaryStage());

    }

    class btnBackEventHandler implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event) {
            WelcomeController welcomeController = new WelcomeController(model);
            welcomeController.show();

        }
    }
    class btnExitEventHandler implements EventHandler<ActionEvent> {
       @Override
        public void handle(ActionEvent event) {
            System.out.println("Atlantis verlassen");
            System.exit(0);
        }

    }

   /* class btnOptionsEventHandler implements EventHandler<MouseEvent>{
        @Override
        public void handle(MouseEvent event) {


        }
    }
*/

}

