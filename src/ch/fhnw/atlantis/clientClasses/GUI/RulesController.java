package ch.fhnw.atlantis.clientClasses.GUI;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;


/**
 * Created by Nadine on 28.11.2016.
 */
public class RulesController {
    private Model model;
    private RulesView view;

    public RulesController(Model model) {
        this.model = model;
        this.view = new RulesView();
    }

    public void show() {
        //    view.show(model.getPrimaryStage());
        Stage secondStage = new Stage();
        secondStage.setX(+400);    // geänderte Position gegenüber PrimaryStage (nach rechts)
        secondStage.setY(+50);     // geänderte Position gegenüber PrimaryStage (nach unten)
        view.show(secondStage);

    }

}