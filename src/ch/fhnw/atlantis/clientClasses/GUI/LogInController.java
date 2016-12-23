package ch.fhnw.atlantis.clientClasses.GUI;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.File;
import java.net.URL;
import java.util.Optional;

/**
 * Author: Nadine
 *
 * MVC - Vorlage zur Strukturierung von Programmen, notwendig um
 * Programme schnell erweitern zu können und sich schnell einarbeiten - schneller Fehler finden
 * Mehrere Views (alles was angezeigt wird) mit mehreren Controller (kümmert sich um Interaktion)und einem Model (Datenablage wie Listen/Werte)
 */

public class LogInController {
    private Model model;
    private LogInView view;
    PlayerClient playerClient = new PlayerClient();
    //private String musicFile = "/ch/fhnw/atlantis/resources/music/atlantismenumusic.ogg";

    //final URL resource = getClass().getResource("");

    public LogInController(Model model) {
        this.model = model;
        this.view = new LogInView();

        //Media media = new Media(new File(musicFile).toURI().toString());
        //final MediaPlayer mediaPlayer = new MediaPlayer(media);
        //mediaPlayer.play();

        view.getBtnConnect().setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {

                String host = view.getIPEnter().trim();
                String portString = view.getPortEnter().trim();
                int portInt = Integer.parseInt(portString);

                playerClient.Host = host;
                playerClient.Port = portInt;

                Client client = new Client();
                int isConnectedclient= client.connectToServer(host, portInt);
                client.sendMessagetoServer("StartGame");

                try {
                    Thread.sleep(1000);
                    if (isConnectedclient == 1){
                        MenuController menuController = new MenuController(model);
                        menuController.show();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        view.getBtnClose().setOnAction(new btnCloseEventHandler());

        // ------------------- CSS Styling den Playern (Icons) zuweisen - WEISS -------------------
        view.getPlayer1().getStyleClass().add("Playerbefore");
        view.getPlayer2().getStyleClass().add("Playerbefore");
        view.getPlayer3().getStyleClass().add("Playerbefore");
        view.getPlayer4().getStyleClass().add("Playerbefore");
        view.getLbl2().setText("Bitte starten Sie den Server und verbinden Sie sich damit");
    }

    public void show() {
        view.show(model.getPrimaryStage());
    }

    class btnCloseEventHandler implements EventHandler<ActionEvent>{
        @Override
        public void handle(ActionEvent event) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION,
                    "Soll Atlantis wirklich beendet werden?", ButtonType.YES, ButtonType.NO);
            alert.setTitle("Confirmation Dialog");
            alert.setHeaderText("Spiel verlassen");

            Optional<ButtonType> result = alert.showAndWait();
            if (result.get()== ButtonType.YES){
                System.out.println("Atlantis verlassen");
                System.exit(0);
            }
        }
    }
}