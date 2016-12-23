package ch.fhnw.atlantis.serverClasses.serverClasses.GUI;
import ch.fhnw.atlantis.clientClasses.Model;
import ch.fhnw.atlantis.serverClasses.Server;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import java.util.Optional;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

/**
 * @Author Nadine
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

        view.getBtnConnect_s().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                startScheduledExecutorService();
            }
        });

        view.getBtnStop_s().setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                String portString = view.getPortServer().trim();
                int portInt = Integer.parseInt(portString);
                Server server = Server.getInstance(portInt);

                event.consume();
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION,
                        "Soll Atlantis wirklich beendet werden?", ButtonType.YES, ButtonType.NO);
                alert.setTitle("Confirmation Dialog");
                alert.setHeaderText("Spiel verlassen");

                Optional<ButtonType> result = alert.showAndWait();
                if (result.get()== ButtonType.YES){
                    server.stopTCP();
                    System.out.println("Atlantis ist geschlossen");
                }
            }
        });

        view.show(model.getPrimaryStage());
    }

    public void startScheduledExecutorService(){
        final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

        String portString = view.getPortServer().trim();
        int portInt = Integer.parseInt(portString);

        view.setTxtLog("Server Started and is listening on Port: " + portInt);
        Server server = Server.getInstance(portInt);
        view.btnConnect_s.setDisable(true);
        server.startTCP();

        // Starte den UpdateAll Scheduler
        view.updateAll();
    }
}