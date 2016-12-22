package ch.fhnw.atlantis.clientClasses.GUI;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;
import java.util.Optional;

/**
 * Author Nadine
 *
 */
public class RangkingByeController {
    private Model model;
    private RankingByeView view;

    public RangkingByeController(Model model) {
        this.model = model;
        this.view = new RankingByeView();

        view.getEndbtn().setOnAction(new btnEndEventHandler());
        view.getRestartbtn().setOnAction(new btnRestartEventHandler());

    }

    public void show() {
        //    view.show(model.getPrimaryStage());
        Stage secondStage = new Stage();
          view.show(secondStage);

        secondStage.setOnCloseRequest(event -> {
            event.consume();
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION,
                    "Soll Atlantis wirklich beendet werden?", ButtonType.YES, ButtonType.NO);
            alert.setTitle("Confirmation Dialog");
            alert.setHeaderText("Spiel verlassen");
            alert.initOwner(secondStage);

            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.YES) {
                Platform.exit();
                System.out.println("Atlantis ist geschlossen");
            }
        });
    }

    class btnEndEventHandler implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION,
                    "Soll Atlantis wirklich verlassen werden?", ButtonType.YES, ButtonType.NO);
            alert.setTitle("Confirmation Dialog");
            alert.setHeaderText("Spiel endgültig verlassen");

            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.YES) {
                System.out.println("Atlantis verlassen");
                System.exit(0);
            }
        }
    }
    class btnRestartEventHandler implements EventHandler<ActionEvent>{
        @Override
        public void handle(ActionEvent event) {
            MenuController menuController = new MenuController(model);
            menuController.show();
        }
    }

}