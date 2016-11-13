package ch.fhnw.atlantis.clientClasses.GUI;

import ch.fhnw.atlantis.globalClasses.models.GameBoard;
import ch.fhnw.atlantis.globalClasses.models.TileFactory;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;

public class GameBoardView extends Application {

    private double sceneWidth = 1024;
    private double sceneHeight = 768;

    private int n = 10;
    private int m = 10;

    double gridWidth = 100;
    double gridHeight = 100;

    MyNode[][] playfield = new MyNode[n][m];

    @Override
    public void start(Stage primaryStage) throws FileNotFoundException {
        Group root = new Group();
        ImageView[] iVArray = new ImageView[20];
        ImageView iV1 = new ImageView();

        //ImageView r1 = new ImageView();
        //r1.setImage(getImage("blue_2.jpg"));

        int iVCounter = 0;

        //r1.setImage(getImage("blue_2.jpg"));

        // initialize playfield
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                MyNode node = null;
                // create obstacle
                if (i == 0 && j == 1) {
                    node = new Tile(getImage("blue_1.jpg"), i, j);}
                //} else if (i == 0 && j == 2) {
                //    node = new Tile(getImage("blue_1.jpg"), i, j);
                //} else if (i == 0 && j == 3) {
                //    node = new Tile(getImage("blue_1.jpg"), i, j);
                //} else if (i == 0 && j == 4) {
                //    node = new Tile(getImage("blue_1.jpg"), i, j);
                //} else if (i == 1 && j == 4) {
                //    node = new Tile(getImage("blue_1.jpg"), i, j);
                //} else if (i == 2 && j == 4) {
                //    node = new Tile(getImage("blue_1.jpg"), i, j);
                //} else if (i == 3 && j == 4) {
                //    node = new Tile(getImage("blue_1.jpg"), i, j);
                //} else if (i == 3 && j == 3) {
                //    node = new Tile(getImage("blue_1.jpg"), i, j);
                //} else if (i == 3 && j == 2) {
                //    node = new Tile(getImage("blue_1.jpg"), i, j);
                //} else if (i == 3 && j == 1) {
                //    node = new Tile(getImage("blue_1.jpg"), i, j);
                //}
                // add node to group
                if (node != null) {
                    root.getChildren().add(node);
                    // add to playfield for further reference using an array
                    playfield[i][j] = node;
                }

            }
        }

        Scene scene = new Scene(root, sceneWidth, sceneHeight);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {

        Application.launch(args);
    }

    private class Tile extends MyNode {
        public Tile(Image path, int x, int y) {
            super(path, x, y);
        }
    }


    private class MyNode extends StackPane {

    public MyNode(Image path, double x, double y) {

        // create rectangle
        ImageView iv = new ImageView(path);
        iv.setFitWidth(100);
        iv.setFitHeight(100);

        //rectangle.setStroke( color);
        //rectangle.setFill( color.deriveColor(1, 1, 1, 0.7));

        // set position
        setTranslateX(x * gridWidth);
        setTranslateY(y * gridHeight);

        getChildren().add(iv);

        }
    }

    private static Image getImage(String imageName) throws FileNotFoundException {

        String imagePath = "ch/fhnw/atlantis/resources/images/";

        //File f = new File(imagePath + imageName);
        //if (!f.exists()) {
        //throw new FileNotFoundException(imagePath + imageName + " wasn't found.");
        //}
        try {
            return new Image(imagePath + imageName);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }
}

