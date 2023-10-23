package asuender;

/**
 * Diese Klasse ist dazu da, eine Statistik für den Worttrainer zu speichern.
 * @author Andreas Suender
 * @version 09-19-2021
 */
public class WortStatistik {
    private int abfragenGesamt;
    private int abfragenRichtig;

    /**
     * Initialisiert ein leeres Statistik-Objekt.
     */
    public WortStatistik() {}

    /**
     * Initialisiert ein Statistik-Objekt mit der Anzahl der zu prüfenden Abfragen.
     * Anders würde es wenig Sinn machen. Muss größer als 0 sein.
     * @param abfragenGesamt Anzahl der zu prüfenden Abfragen
     */
    public WortStatistik(int abfragenGesamt) {
        if (abfragenGesamt < 1) {
            throw new IllegalArgumentException("Die Anzahl der Abfragen muss größer als 0 sein!");
        }

        this.abfragenGesamt = abfragenGesamt;
    }

    /**
     * Gibt die Anzahl der insgesamt zu prüfenden Abfragen zurück.
     * @return Anzahl der insgesamt zu prüfenden Abfragen
     */
    public int getAbfragenGesamt() {
        return abfragenGesamt;
    }

    /**
     * Setzt die Anzahl der insgesamt zu prüfenden Abfragen.
     * Muss größer als 0 sein.
     * @param abfragenGesamt Anzahl der insgesamt zu prüfenden Abfragen
     */
    public void setAbfragenGesamt(int abfragenGesamt) {
        if (abfragenGesamt < 1) {
            throw new IllegalArgumentException("Die Anzahl der Abfragen muss größer als 0 sein!");
        }

        this.abfragenGesamt = abfragenGesamt;
    }

    /**
     * Gibt die Anzahl der bisher richtig beantworteten Abfragen zurück.
     * @return Anzahl der bisher richtig beantworteten Abfragen
     */
    public int getAbfragenRichtig() {
        return abfragenRichtig;
    }

    /**
     * Addiert eine richtige Abfrage zur bestehenden Statistik.
     */
    public void addiereRichtigeAbfrage() {
        ++this.abfragenRichtig;
    }

    /**
     * Addiert eine Abfrage zur bestehenden Statistik.
     */
    public void erhoeheGesamtabfragen() {
        ++this.abfragenGesamt;
    }

    /**
     * Gibt das Ergebnis der "Statistik" in Prozent zurück.
     * @return Ergebnis in Prozent
     */
    public double ergebnis() {
        double ergebnis = abfragenRichtig*100.0 / abfragenGesamt;

        this.abfragenGesamt = 0;
        this.abfragenRichtig = 0;

        return ergebnis;
    }
}
