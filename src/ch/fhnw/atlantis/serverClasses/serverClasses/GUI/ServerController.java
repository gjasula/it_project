package ch.fhnw.atlantis.serverClasses.serverClasses.GUI;
import ch.fhnw.atlantis.clientClasses.GUI.Model;
import ch.fhnw.atlantis.serverClasses.Server;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.TextField;

/**
 * Created by Nadine on 19.10.2016.
 */

public class ServerController {


    private Model model;
    // View
    private ServerView view;
    private Server server;


    public ServerController(Model model) {
        this.model = model;
        this.view = new ServerView();
    }

    public void show() {
        view.show(model.getPrimaryStage());

        view.getBtnConnect_s().setOnAction(new btnConnectEventHandler());
    }
}

    class btnConnectEventHandler implements EventHandler<ActionEvent>{
        @Override
        public void handle(ActionEvent event) {

            Server server = Server.getInstance(7766);

            server.startTCP();

        }
    }


