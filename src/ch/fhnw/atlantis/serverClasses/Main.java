package ch.fhnw.atlantis.serverClasses;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * Team Gerstenland
 * Created by Jürg Steudler
 *
 */

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start (Stage stage) throws Exception {
        Button button = new Button();
        button.setOnAction(event -> System.out.println("Hello World!"));

        StackPane root = new StackPane();
        root.getChildren().add(button);

        Scene scene = new Scene(root, 800, 600);

        stage.setTitle("Atlantis - Client - Team Gerstenland");
        stage.setScene(scene);
        stage.show();

    }
}
