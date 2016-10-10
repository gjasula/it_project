package ch.fhnw.atlantis.clientClasses.GUI;

import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.effect.Glow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Created by Nadine on 09.10.2016.
 */
public class GameMenu extends Application {
    // Diese Seite zeigt die grafische Oberfläche des Hauptmenus
// VORLAGE: https://www.youtube.com/watch?v=aOcow70vqb4

        // create Menu
        private Menu Menu;

        @Override
        public void start(Stage primaryStage) throws Exception {

            // Load Image and define as Background
            Pane root = new Pane();
            root.setPrefSize(800, 600);

            InputStream is = Files.newInputStream(Paths.get("C:\\Users\\nadin\\IdeaProjects\\GuiVersuch_XYZ\\.idea\\Images\\gerste08.jpg"));
            Image img = new Image(is);
            // Input Stream muss geschlossen werden, da sonst andere Programme Zugriff haben und so blockiert werden kann
            is.close();

            ImageView imgView = new ImageView(img);
            // Grösse des Hintergrundbildes anpassen auf Fenstergrösse
            imgView.setFitWidth(800);
            imgView.setFitHeight(600);

            Menu = new Menu();

            // Display Image und gameMenu
            root.getChildren().addAll(imgView, Menu);


            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.setTitle("Atlantis by Team Gerstenland: Hauptmenu");
            primaryStage.show();
        }
        // Hier werden die einzelnen Button erstellt und mit Namen versehen

        private class Menu extends Parent {
            public Menu() {                           // Kontruktor
                VBox menu0 = new VBox(10);                // Vertical Box: untereinander mit dem Abstand von 10
                VBox menu1 = new VBox(10);

                // Menu0 : Hauptmenu   Menu1: Sub-Menu
                menu0.setTranslateX(100);
                menu0.setTranslateY(200);

                menu1.setTranslateX(100);
                menu1.setTranslateY(200);

                // Animation Effect
                final int offset = 400;
                menu1.setTranslateX(offset);


                MenuButton btnResume = new MenuButton("RESUME");
                //     btnResume.setOnMouseClicked(event -> {
                //     getChildren().add(menu0);
                //     });

                MenuButton btnOptions = new MenuButton("SPRACHE WÄHLEN");
                btnOptions.setOnMouseClicked(event -> {
                    getChildren().add(menu1);                       // hier wird das Unter-Menu von Options erstellt

                    // damit das Untermenu an den Platz des Hauptmenus rutscht - Effekt: "weg rutschen nach Links"
                    TranslateTransition tt = new TranslateTransition(Duration.seconds(0.5), menu0);
                    tt.setToX(menu0.getTranslateX()- offset);

                    TranslateTransition tt1 = new TranslateTransition(Duration.seconds(0.5), menu1);
                    tt1.setToX(menu0.getTranslateX());

                    tt.play();
                    tt1.play();
                    // hier wird Hauptmenu ausgeblendet
                    tt.setOnFinished(evt -> {
                        getChildren().remove(menu0);
                    });
                });

                MenuButton btnExit = new MenuButton("SCHLIESSEN");
                btnExit.setOnMouseClicked(event -> {
                    System.exit(0);
                });

                MenuButton btnBack = new MenuButton("ZURÜCK");
                btnBack.setOnMouseClicked(event -> {
                    getChildren().add(menu0);
                    // damit das Hauptmenu an den Platz des Untermenus zurückrutscht - Effekt: "weg rutschen nach Links"
                    TranslateTransition tt = new TranslateTransition(Duration.seconds(0.5), menu1);
                    tt.setToX(menu1.getTranslateX()+ offset);

                    TranslateTransition tt1 = new TranslateTransition(Duration.seconds(0.5), menu0);
                    tt1.setToX(menu1.getTranslateX());

                    tt.play();
                    tt1.play();
                    // hier wird Untermenu ausgeblendet
                    tt.setOnFinished(evt -> {
                        getChildren().remove(menu1);
                    });
                });

                MenuButton btnSprache1 = new MenuButton ("DEUTSCH");
                MenuButton btnSprache2 = new MenuButton ("ENGLISCH");

                menu0.getChildren().addAll(btnResume, btnOptions, btnExit);
                menu1.getChildren().addAll(btnBack, btnSprache1, btnSprache2);

                // Hintergrund des Menus
                Rectangle bg = new Rectangle(800, 600);
                bg.setFill(Color.GHOSTWHITE);
                bg.setOpacity(0.4);

                getChildren().addAll(bg, menu0);
            }
        }

        // Design MenuButton mit StackPane (Grauer Hintergrund mit Text) - aufeinander stapeln (zuerst Rechteck und dann Text drauf)
        private static class MenuButton extends StackPane {
            // damit Text geschrieben werden kann für den Button
            private Text text;

            public MenuButton(String name) {
                text = new Text(name);
                text.setFont(text.getFont().font(20));            // Schriftgrösse
                text.setFill(Color.SNOW);                         // Schriftfarbe "Weiss"

                // Rechteck "Button"
                Rectangle bg = new Rectangle(250, 30);
                bg.setOpacity(0.6);                              // Effekt "Intransparenz"
                bg.setFill(Color.GREY);
                bg.setEffect(new GaussianBlur(3.5));            // Effekt "trüben"

                setAlignment(Pos.CENTER_LEFT);                  // Position im Fenster
                getChildren().addAll(bg, text);                 // zuerst Background und dann Text - sonst ist Text hinter dem Retangle

                setOnMouseEntered(event -> {                    // Effekt " Wenn Maus über Menu Feld wischt wird Feld ein wenig nach rechts geschoben"
                    bg.setTranslateX(10);
                    text.setTranslateX(10);
                    bg.setFill(Color.WHITE);                   // hier wird die Farbe vertauscht beim darüber Fahren
                    text.setFill(Color.GRAY);
                });

                setOnMouseExited(event -> {                // Hier wird der Effekt von oben wieder rückgängig gemacht
                    bg.setTranslateX(0);
                    text.setTranslateX(0);
                    bg.setFill(Color.GRAY);
                    text.setFill(Color.WHITE);
                });

                DropShadow drop = new DropShadow(50, Color.WHITE);         // Effekt "Aufleuchten"
                drop.setInput(new Glow());

                setOnMousePressed(event -> setEffect(drop));               // Aufleuchten wird beim Klicken auf den Button erzeugt
                setOnMouseReleased(event -> setEffect(null));
            }
        }

        // entry Point for Application - Launch für die Ausführung
        public static void main(String[] args) {
            launch(args);
        }
    }

