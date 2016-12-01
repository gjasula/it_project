package ch.fhnw.atlantis.clientClasses.GUI;

import javafx.stage.Stage;

/**
 * Created by Nadine on 28.11.2016.

public class RangkingByeController {
    private Model model;
    private RankingByeView view;

    public RangkingByeController (Model model){
        this.model = model;
        this.view = new RankingByeView();

    }

    public void show(){
        Stage secondStage = new Stage();
        view.show(secondStage);
    }
}
*/



