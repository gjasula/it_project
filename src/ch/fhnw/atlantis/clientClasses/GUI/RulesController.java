package ch.fhnw.atlantis.clientClasses.GUI;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;


/**
 * Created by Nadine on 28.11.2016.
 */
public class RulesController {
    private Model model;
    private RulesView view;

    public RulesController(Model model){
        this.model = model;
        this.view = new RulesView();

        view.getBtnBack2().setOnAction(new btnBack2EventHandler());

    }

    public void show(){
        view.show(model.getPrimaryStage());

    }

    class btnBack2EventHandler implements EventHandler<ActionEvent>{
        @Override
        public void handle(ActionEvent event) {
            MenuController menuController = new MenuController(model);
            menuController.show();
        }
    }
}