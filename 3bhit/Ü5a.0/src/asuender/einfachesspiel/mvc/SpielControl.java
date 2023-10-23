package asuender.einfachesspiel.mvc;

import asuender.einfachesspiel.mvc.model.GewinnModel;
import asuender.einfachesspiel.mvc.view.SpielFrame;
import asuender.einfachesspiel.mvc.view.SpielLayout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Controller-Klasse für das "Einfache Spiel". Dient auch als ActionListener für das Panel.
 * @author Andreas Suender
 * @version 09-14-2021
 */
public class SpielControl implements ActionListener {
    private GewinnModel model;
    private SpielFrame frame;
    private SpielLayout layout;

    /**
     * Initialisiert das Spiel mit allen benötigten Objekten und einem bestimmten Fenstertitel.
     * @param title Fenstertitel
     */
    public SpielControl(String title) {
        this.model = new GewinnModel();
        this.layout = new SpielLayout(this, this.model.getGesamtPunkte());
        this.frame = new SpielFrame(title, this.layout);
    }

    /**
     * Methode, welche das ActionEvent abföngt, welches wiederrum vom Panel geworfen wird.
     * Evtl. Fehleingaben sollten schon vorher durch das Layout behoben worden sein (diese sind markiert mit dem Code 99)
     * @param e ActionEvent, welches vom Panel geworfen wird.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        if (command.equals("calculate")) {
            int value = this.layout.getUserInput();

            // 99 bedeutet Fehler
            if (value != 99) {
                this.model.berechneComputerZahl();
                this.model.berechneRunde(this.layout.getUserInput());
                this.layout.showResult(this.model.getGesamtPunkte(), this.model.getComputerZahl(), this.model.getRundenErgebnis());
            }
        }

        if (command.equals("try again")) {
            this.layout.tryAgain();
        }
    }

    public static void main(String[] args) {
        new SpielControl("Gewinnspiel");
    }
}
