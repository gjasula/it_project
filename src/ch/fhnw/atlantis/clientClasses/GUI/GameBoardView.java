package ch.fhnw.atlantis.clientClasses.GUI;

import ch.fhnw.atlantis.globalClasses.ImageLoader;
import ch.fhnw.atlantis.globalClasses.interfaces.ITile;

import ch.fhnw.atlantis.globalClasses.models.GameBoard;
import javafx.application.Application;
import javafx.geometry.Insets;

import javafx.scene.Group;

import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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

    GridPane[][] gameBoard = new GridPane[COL][ROW];

    BorderPane bp = new BorderPane();

    @Override
    public void start(Stage primaryStage) throws FileNotFoundException {
        primaryStage.setTitle("GridPane example");

        //Adding GridPane
        GridPane gridPane = new GridPane();

        // 2D array of Buttons with value of 5,5
        ImageView[][] iV = new ImageView[COL][ROW];

        //Column is a vertical line and row is a horizontal line
        //Two FOR loops used for creating 2D array of buttons with values i,j
        for (ITile tiles : model.gameBoard.getTilesToBoard()) {
        for(int i=0; i<COL; i++){
            for(int j=0; j<ROW;j++){

                //Initializing 2D buttons with values i,j
                //iV[i][j] = new ImageView(ImageLoader.getImage("blue_1.jpg"));
                iV[i][j] = new ImageView(ImageLoader.getImage(tiles.getTile().getPath()));

                gridPane.add(iV[i][j], i, j);
            }
        }

        //Adding GridPane to the scene
        Scene scene = new Scene(gridPane);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    }

    /**
     *
     * @param primaryStage
     * @throws FileNotFoundException

    @Override
    public void start(Stage primaryStage) throws FileNotFoundException {
        //createCards();
        HBox playField = new HBox();



        GridPane pane = new GridPane();
        Node node = new ImageView();

        for(int i = 0; i < COL; i++) {
            ColumnConstraints col = new ColumnConstraints();
            col.setHgrow(Priority.ALWAYS);
            //pane.getColumnConstraints().add(col);
            for (int j = 0; j < ROW; j++) {
                RowConstraints row = new RowConstraints();
                row.setVgrow(Priority.ALWAYS);
                //gameBoard.getRowConstraints().add(row);
                gameBoard[i][j] = pane;
            }

        //gameBoard = GameBoardView.initGridPane(COL, ROW);

        //playField.getChildren().add(pane);

        bp.setCenter(pane);



        Scene scene = new Scene(bp, sceneWidth, sceneHeight);

        primaryStage.setScene(scene);
        primaryStage.show();
        }
    }  */

    /**
     *
     * @param
     * @param
     * @return

    private static GridPane[][] initGridPane(int x, int y) {

        }

        //pane.setTranslateX(x * gridWidth);
        //pane.setTranslateY(y * gridHeight);
        return pane;
    }
     */
    public static void main(String[] args) {

        Application.launch(args);

        //GameBoard.class.getImageFromEnum();
    }

    /**
     *
     * @throws FileNotFoundException
     */
    public void createCards() throws FileNotFoundException {

        GridPane gridPane;
        StackPane sp = new StackPane();
        Group root = new Group();
        Node node = new ImageView();

        ImageView iv = new ImageView();
        iv.setFitWidth(75);
        iv.setFitHeight(75);

        for (ITile tiles : model.gameBoard.getTilesToBoard()) {
            for (int i = 0; i < COL; i++) {
                for (int j = 0; j < ROW; j++) {
                    gridPane = null;
                    // create obstacle
                    if (i == 1 && j == 1) {
                        node = new ImageView(ImageLoader.getImage(tiles.getTile().getPath()));
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