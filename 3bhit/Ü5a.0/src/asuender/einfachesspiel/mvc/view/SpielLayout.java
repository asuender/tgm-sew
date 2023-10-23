package asuender.einfachesspiel.mvc.view;

import asuender.einfachesspiel.mvc.SpielControl;

import javax.swing.*;
import java.awt.*;

/**
 * Panel mit der eigentlichen UI für das "Einfache Spiel".
 * @author Andreas Suender
 * @version 14-09-2021
 */
public class SpielLayout extends JPanel {
    private JPanel gridPanel;
    private JButton buttonRepeat;
    private JLabel labelTotalPnts, labelPnts;
    private JTextField inputNumber, textAINumber;

    /**
     * Initialisiert das Panel mit dem Controller, welches für die Events benötigt wird und den Startpunkten.
     * @param controller Controller für die Events
     * @param startpunkte Startpunkte
     */
    public SpielLayout(SpielControl controller, int startpunkte) {
        final Font textFieldFont = new Font("Arial", Font.BOLD, 32);

        this.setLayout(new BorderLayout());

        this.gridPanel = new JPanel(new GridLayout(4, 2));

        this.gridPanel.add(new JLabel("Punkte gesamt:"));
        this.gridPanel.add(new JLabel("Aktuelles Ergebnis:"));

        this.labelTotalPnts = new JLabel(String.format("%d", startpunkte));
        this.gridPanel.add(labelTotalPnts);

        this.labelPnts = new JLabel("");
        this.gridPanel.add(labelPnts);

        this.gridPanel.add(new JLabel("Zahl für nächste Runde:"));
        this.gridPanel.add(new JLabel("Computerzahl"));

        this.inputNumber = new JTextField(1);
        this.inputNumber.setFont(textFieldFont);
        this.inputNumber.setActionCommand("calculate");
        this.inputNumber.addActionListener(controller);
        this.gridPanel.add(this.inputNumber);

        this.textAINumber = new JTextField(1);
        this.textAINumber.setFont(textFieldFont);
        this.textAINumber.setEditable(false);
        this.gridPanel.add(this.textAINumber);

        // ist ein wenig mehr extended stuff, der Code sieht aber besser aus
        for (Component c : this.gridPanel.getComponents()) {
            if (c.getClass().equals(JLabel.class)) {
                JLabel label = ((JLabel) c);
                label.setHorizontalAlignment(JLabel.CENTER);
                label.setOpaque(true);
            }

            if (c.getClass().equals(JTextField.class)) {
                ((JTextField) c).setHorizontalAlignment(JLabel.CENTER);
            }
        }

        this.add(this.gridPanel, BorderLayout.PAGE_START);

        this.buttonRepeat = new JButton("Noch einmal!");
        this.buttonRepeat.setEnabled(false);
        this.buttonRepeat.setActionCommand("try again");
        this.buttonRepeat.addActionListener(controller);
        this.add(this.buttonRepeat, BorderLayout.PAGE_END);
    }

    /**
     * Gibt den eingegebenen Wert aus dem linken Textfeld (welches vom Benutzer gesteuert wird) zurück.
     * Hier wird der Wert auch auf Richtigkeit überprüft!
     * @return eingegebenen Wert
     */
    public int getUserInput() {
        int value;

        try {
            value = Integer.parseInt(this.inputNumber.getText());

            if (!(value >= 0 && value <= 9)) {
                throw new IllegalArgumentException();
            }
            // da die NFE von der IAE erbt, wird diese hier auch abgefangen
        } catch (IllegalArgumentException exception) {
            value = 99; // Fehler(-code)
        }

        return value;
    }

    /**
     * Zeigt das Ergebnis der aktuellen Runde an. Dabei wird ggf. der Text "VERLOREN" bzw. "GEWONNEN" angezeigt."
     * @param totalpnts aktuelle Gesamtpunkte
     * @param ainumber Computergenerierte Zahl
     * @param pnts Punkte der aktuellen Runde
     */
    public void showResult(int totalpnts, int ainumber, int pnts) {
        this.inputNumber.setEditable(false);
        this.buttonRepeat.setEnabled(true);

        this.textAINumber.setText(String.format("%d", ainumber));

        String labelAllPointsText = String.format("%d", totalpnts);
        if (totalpnts <= 0) {
            labelAllPointsText = "VERLOREN!";
            this.labelTotalPnts.setBackground(Color.RED);
        }
        else if (totalpnts >= 100) {
            labelAllPointsText = "GEWONNEN!";
            this.labelTotalPnts.setBackground(Color.GREEN);
        }
        this.labelTotalPnts.setText(labelAllPointsText);

        this.labelPnts.setBackground(pnts > 0 ? Color.GREEN : Color.RED);
        this.labelPnts.setText(String.format("%d", pnts));
    }

    /**
     * Setzt die UI für eine weitere Runde zurück.
     */
    public void tryAgain() {
        this.inputNumber.setEditable(true);
        this.inputNumber.setText("");
        this.textAINumber.setText("");
    }
}
