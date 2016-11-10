package ch.fhnw.atlantis.clientClasses.GUI;
/**
 * Created by Nadine on 19.10.2016.
 */

public class ServerController {
    // ch.fhnw.atlantis.clientClasses.GUI.Model
    private Model model;
    // View
    private ServerView view;


    public ServerController (Model model){
        this.model = model;
        this.view = new ServerView();
    }

    public void show(){
        view.show(model.getPrimaryStage());

    }

}

