package ch.fhnw.atlantis.clientClasses.GUI;


import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.WindowEvent;

import java.util.Optional;


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
        view.getBtnRules().setOnAction(new btnRulesEventHandler());


    //    view.getBtnOptions().setOnMouseClicked(new btnOptionsEventHandler());

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
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION,
            "Soll Atlantis wirklich beendet werden?", ButtonType.YES, ButtonType.NO);
            alert.setTitle("Confirmation Dialog");
            alert.setHeaderText("Spiel verlassen");


            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.YES) {
                System.exit(0);
                System.out.println("Atlantis verlassen");

            }

        }

    }

    class btnRulesEventHandler implements EventHandler<ActionEvent>{
        @Override
        public void handle(ActionEvent event) {

            RulesController rulesController = new RulesController(model);
            rulesController.show();

        }
    }
}


