package asuender;

import java.util.Random;

/**
 * Diese Klasse dient als "Trainer"-Klasse für den Rechtschreibtrainer.
 * @author Andreas Suender
 * @version 09-19-2021
 */
public class WortTrainer {
    private WortListe liste;
    private int selected;

    private WortStatistik statistik;

    /**
     * Initialisiert ein WortTrainer-Objekt, dabei muss eine Wortliste angegeben werden.
     * Sollte diese leer sein, so wird eine Exception ausgelöst.
     * @param liste Wortliste, die gespeichert werden soll
     */
    public WortTrainer(WortListe liste) {
        if (liste.getLength() == 0) throw new IllegalArgumentException("Die Liste ist leer!");

        this.liste = liste;
        this.selected = -1; // -1 markiert "kein Eintrag verfügbar"
        this.statistik = new WortStatistik();
    }

    /**
     * Gibt einen zufälligen Eintrag aus der intern gespeicherten Wortliste zurück.
     * Sollte diese leer sein, so wird eine Exception ausgelöst.
     * @return zufälliger Eintrag
     */
    public WortEintrag randomEntry() {
        if (this.liste.getLength() == 0) throw new IllegalArgumentException("Die Liste ist leer!");

        Random generator = new Random();
        this.selected = generator.nextInt(this.liste.getLength());

        return this.liste.eintragAt(this.selected);
    }

    /**
     * Für diese Klasse macht es Sinn, eine neue Liste speichern zu können.
     * @param liste neue Wortliste, die gespeichert werden soll
     */
    public void setListe(WortListe liste) {
        this.liste = liste;
    }

    /**
     * Gibt den aktuell ausgewählten Worteintrag zurück.
     * @return den aktuellen ausgewählten Worteintrag
     */
    public WortEintrag getSelected() {
        if (this.selected == -1) {
            throw new IllegalArgumentException("Kein Eintrag verfügbar! Bitte ggf. 'randomEntry()' davor aufrufen.");
        }

        return this.liste.eintragAt(this.selected);
    }

    /**
     * Überprüft, ob das Wort des aktuell ausgewählten Worteintrages mit dem übergebenen Wort
     * übereinstimmt. Dabei wird auf dieselben Kriterien (bzgl. Länge) geachtet wie in der Klasse
     * 'asuender.WortEintrag'.
     * Zusätzlich wird die Statistik aktualisiert.
     * @param wort Wort, welches verglichen werden soll
     * @return true, wenn die Wörter übereinstimmten, sonst false
     */
    public boolean check(String wort) {
        if (wort.trim().length() < 2 || wort == null) {
            throw new IllegalArgumentException("Das Wort muss mind. 2 Buchstaben lang sein!");
        }

        boolean equal = this.getSelected().getWort().equals(wort);
        if (equal) {
            this.statistik.addiereRichtigeAbfrage();
        }
        this.statistik.erhoeheGesamtabfragen();

        return equal;
    }

    /**
     * Wie die 'check'-Methode oben, diese achtet hier aber nicht auf die Groß- und Kleinschreibung.
     * Zusätzlich wird die Statistik aktualisiert
     * @param wort Wort, welches verglichen werden soll
     * @return true, wenn die Wörter übereinstimmten, sonst false
     */
    public boolean checkIgnoreCase(String wort) {
        if (wort.trim().length() < 2 || wort == null) {
            throw new IllegalArgumentException("Das Wort muss mind. 2 Buchstaben lang sein!");
        }

        boolean equal = this.getSelected().getWort().equalsIgnoreCase(wort);
        if (equal) {
            this.statistik.addiereRichtigeAbfrage();
        }
        this.statistik.erhoeheGesamtabfragen();

        return equal;
    }

    public double zeigeErgebnis() {
        double ergebnis = this.statistik.ergebnis();

        this.liste.loescheListe();
        this.selected = -1;

        return ergebnis;
    }
}
