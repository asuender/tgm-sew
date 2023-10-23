package asuender.einfachesspiel.mvc.model;

import java.util.Random;

/**
 * Modelklasse für das "Einfache Spiel". Prinzipiell vorgegeben durch den eLearning-Kurs.
 * @author Andreas Suender, Lisa Vittori
 * @version 09-14-2021
 */
public class GewinnModel {
    private int gesamtPunkte, spielerZahl, computerZahl, rundenErgebnis;
    private Random generator;

    /**
     * Initialisiert das Model. Es werden aber nicht alle Attribute initialisiert, da Java im Normalfall
     * '0' als Anfangswert für Integers hernimmt.
     */
    public GewinnModel() {
        this.gesamtPunkte = 30;
        this.generator = new Random();
    }

    /**
     * Gibt die Gesamtpunkte zurück
     * @return Gesamtpunkte
     */
    public int getGesamtPunkte() {
        return gesamtPunkte;
    }

    /**
     * Gibt die computergenerierte Zahl zurück
     * @return computergenerierte Zahl
     */
    public int getComputerZahl() {
        return computerZahl;
    }

    /**
     * Gibt das Rundenergebnis zurück
     * @return Rundenergebnis
     */
    public int getRundenErgebnis() {
        return rundenErgebnis;
    }

    /**
     * Berechnt die computergenerierte Zahl.
     */
    public void berechneComputerZahl() {
        this.computerZahl = this.generator.nextInt(9)+1;
    }

    /**
     * Berechet das Ergebnis der 1. Runde, gibt dieses aber nicht zurück.
     * @param spielerZahl Zahl, welche der Spieler gewählt hat.
     */
    public void berechneRunde(int spielerZahl) {
        this.spielerZahl = spielerZahl;

        if (spielerZahl == this.computerZahl) {
            this.rundenErgebnis = 20;
        }

        else if (Math.abs(this.computerZahl-spielerZahl) == 1) {
            this.rundenErgebnis = 5;
        }

        else {
            this.rundenErgebnis = -10;
        }

        this.gesamtPunkte += this.rundenErgebnis;
    }
}
