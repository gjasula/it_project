package ch.fhnw.atlantis.clientClasses.GUI;

import javafx.stage.Stage;

/**
 * @Author Nadine
 *
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