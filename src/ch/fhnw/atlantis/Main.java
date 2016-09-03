package ch.fhnw.atlantis;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * Created by team Gerstenland.
 *
 * Richy push test
 */

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start (Stage stage) throws Exception {
        Button button = new Button();
        button.setText("klick mich!");
        button.setOnAction(event -> System.out.println("Hello World!"));

        StackPane root = new StackPane();
        root.getChildren().add(button);

        Scene scene = new Scene(root, 300, 200);

        stage.setTitle("Hello World App");
        stage.setScene(scene);
        stage.show();

    }
}
