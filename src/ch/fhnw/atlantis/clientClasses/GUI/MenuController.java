package ch.fhnw.atlantis.clientClasses.GUI;


import javafx.event.ActionEvent;
import javafx.event.EventHandler;


/**
 * Created by Nadine on 25.10.2016.
 */

public class MenuController {
    private Model model;
    private MenuView view;


    public MenuController(Model model) {
        this.model = model;
        this.view = new MenuView();

        view.getBtnBack().setOnAction(new btnBackEventHandler());
        view.getBtnExit().setOnAction(new btnExitEventHandler());

    //    view.getBtnOptions().setOnMouseClicked(new btnOptionsEventHandler());

        view.getBtnOptions().setOnMouseClicked(event ->{

            });

        }


    public void show(){
        view.show(model.getPrimaryStage());

    }

    class btnBackEventHandler implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event) {
            LogInController logInController = new LogInController(model);
            logInController.show();

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

