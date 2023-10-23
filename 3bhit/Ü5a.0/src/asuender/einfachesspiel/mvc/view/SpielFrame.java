package asuender.einfachesspiel.mvc.view;

import javax.swing.*;

/**
 * Frame-Klasse für das "einfache Spiel".
 * @author Andreas Suender
 * @version 09-14-2021
 */
public class SpielFrame extends JFrame {
    /**
     * Initialisiert das Frame mit dem Fenstertitel und dem Panel, welches in dieses Frame eingefügt werden soll.
     * @param title Fenstertitel
     * @param panel Panel mit der eigentlichen UI des Spiels
     */
    public SpielFrame(String title, SpielLayout panel) {
        super(title);
        this.add(panel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.pack();
        this.setVisible(true);
    }
}
