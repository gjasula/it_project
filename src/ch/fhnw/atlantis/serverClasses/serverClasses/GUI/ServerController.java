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
        //view.show(model.getPrimaryStage());

        //view.getBtnConnect_s().setOnAction(new btnConnectEventHandler());

        view.getBtnConnect_s().setOnAction(new EventHandler<ActionEvent>(){

            @Override
            public void handle(ActionEvent event) {

                String portString = view.getPortServer().trim();
                int portInt = Integer.parseInt(portString);

                Server server = Server.getInstance(portInt);
                view.setTxtLog("Server Started and is listening on Port: " + portInt);
                view.btnConnect_s.setDisable(true);
                server.startTCP();
            }
        });

        view.show(model.getPrimaryStage());
    }
}

    //class btnConnectEventHandler implements EventHandler<ActionEvent>{
//
    //    private ServerView view;
//
    //    @Override
    //    public void handle(ActionEvent event) {
    //        this.view = new ServerView();
    //        //ServerController show = new ServerController();
    //        //serverView.getPortServer();
    //        //String portString = serverView.getPortServer().trim();
    //        //int portInt = Integer.parseInt(portString);
    //        //System.out.println(portInt);
//
    //        //serverView.setPortServer("8888");
//
//
    //        view.setTxtLog();
    //        view.txtLog.appendText("testasd1");
    //        //txtLog.appendText("OK\n");
//
//
    //        Server server = Server.getInstance(7777);
    //        server.startTCP();
//
    //    }
    //}


