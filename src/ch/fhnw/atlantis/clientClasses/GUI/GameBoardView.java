package ch.fhnw.atlantis.clientClasses.GUI;

import ch.fhnw.atlantis.globalClasses.ImageLoader;
import ch.fhnw.atlantis.globalClasses.interfaces.ITile;

import javafx.application.Application;
import javafx.geometry.Insets;

import javafx.scene.Group;

import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;

import javafx.stage.Stage;


import java.io.FileNotFoundException;


public class GameBoardView extends Application {

    private double sceneWidth = 1024;
    private double sceneHeight = 768;

    int COL = 16;
    int ROW = 10;

    int gridWidth = 90;
    int gridHeight = 90;

    private GameBoardModel model = new GameBoardModel();

    private GridPane[][] gameBoard = new GridPane[COL][ROW];

    BorderPane borderPane = new BorderPane();
    @Override
    public void start(Stage primaryStage) throws FileNotFoundException {
        createCards();
        HBox playField = new HBox();

        gameBoard = GameBoardView.initGridPane(COL, ROW);

        //playField.getChildren().add(gameBoard);

        borderPane.setCenter(playField);



        Scene scene = new Scene(borderPane, sceneWidth, sceneHeight);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private static GridPane[][] initGridPane(int x, int y) {
        int COL = 16;
        int ROW = 10;

        GridPane pane [][] = new GridPane[COL][ROW];

        for(int i = 0; i < COL; i++) {
            ColumnConstraints col = new ColumnConstraints();
            col.setHgrow(Priority.ALWAYS);
            //pane.getColumnConstraints().add(col);
        }
        for(int j = 0; j < COL; j++) {
            RowConstraints row = new RowConstraints();
            row.setVgrow(Priority.ALWAYS);
            //gameBoard.getRowConstraints().add(row);
        }


        //pane.setTranslateX(x * gridWidth);
        //pane.setTranslateY(y * gridHeight);
        return pane;
    }

    public static void main(String[] args) {

        Application.launch(args);

        //GameBoard.class.getImageFromEnum();
    }


    public void createCards() throws FileNotFoundException {

        GridPane gridPane;
        StackPane sp = new StackPane();
        Group root = new Group();

        ImageView iv = new ImageView();
        iv.setFitWidth(75);
        iv.setFitHeight(75);

        for (ITile tiles : model.gameBoard.getTilesToBoard()) {
            for (int i = 0; i < COL; i++) {
                for (int j = 0; j < ROW; j++) {
                    gridPane = null;
                    // create obstacle
                    if (i == 1 && j == 1) {
                        iv = new ImageView(ImageLoader.getImage(tiles.getTile().getPath()));
                    }
                    //add node to group
                    if (iv != null) {
                        root.getChildren().add(iv);
                        // add to playfield for further reference using an array
                        gameBoard[i][j] = gridPane;
                    }

                }
            }
        }
    }
}