package ch.fhnw.atlantis.clientClasses.GUI;


import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Tooltip;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.WindowEvent;
import javafx.util.Duration;

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
                System.out.println("Atlantis ist geschlossen");
                System.exit(0);


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


