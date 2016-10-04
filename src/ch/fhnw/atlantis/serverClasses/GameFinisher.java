package ch.fhnw.atlantis.serverClasses;

/**
 *
 * Team Gerstenland
 * Created by Jürg Steudler
 *
 *
 */

public class GameFinisher {
    private int gameId;


    /**
     * Default Konstruktor
     */
    public GameFinisher() {    }

    /**
     *  Methode zum Abschluss des Spiels, sofern ein Spieler alle Spielfiguren auf dem Festland hat
     */
    public void finishGame() {

    }

    /**
     * Methode zum schliessen des Programms.
     *
     * DEFINIEREN: Soll der aktuelle Spielstand irgendwo Zwischengespeichert werden?
     */
    public void closeGame() {

    }

    /**
     * Methode zum berechnen der Punkte am Ende des Spiels
     */
    private void calculatePoints() {

    }

    /**
     * Methode zum zurücksetzen des GameFinisher Zähler
     */
    private void resetCounter() {

    }

    /**
     * Methode zum setzen des Rankings
     */
    private void setRanking() {
        gameId = Game.getInstance().getGameID();

        displayRanking();
    }

    /**
     * Methode zum Anzeigen der Endpunkte in Tabellenform
     */
    private void displayRanking() {

    }

}
