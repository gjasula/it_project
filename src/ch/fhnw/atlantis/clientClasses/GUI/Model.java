package ch.fhnw.atlantis.clientClasses.GUI;

import ch.fhnw.atlantis.globalClasses.*;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Hashtable;

/**
 * Created by Nadine on 03.11.2016.
 * ch.fhnw.atlantis.clientClasses.GUI.Model: speichert die wichtigen Elemente des Programms
 *
 * PrimaryStage ist das Hauptanwendungsfenster -
 * braucht es um versch. Views anzuzeigen (damit Fenster nicht immer auf und zu geht merkt sich Programm "PrimaryStage")
 * PrimaryStage intern werden die Views durch neue Views ersetzt.
 */

public class Model {
    private Stage primaryStage = null;

    private TileDeck tileDeck;
    private Media media;
    private MediaPlayer mediaPlayer;
    private ArrayList<Player> players;
    private ArrayList<Tile> tiles;
    private Player localPlayer;

    private Hashtable<String, ImageView> htOfImages;

    public Model(Stage primaryStage){

        tileDeck = new TileDeck();

        this.primaryStage = primaryStage;
    }

    public void playMusic() {
        // Play Music after Start of Client
        media = null;
        try {
            media = new Media(getClass().getResource("/ch/fhnw/atlantis/resources/music/atlantismenumusic.mp3").toURI().toString());
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        mediaPlayer = new MediaPlayer(media);
        mediaPlayer.play();
    }

    public void stopMusic(){
        mediaPlayer.stop();
    }

    // Getter and Setter

    public Stage getPrimaryStage(){
        return primaryStage;
    }
}


