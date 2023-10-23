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

    public WortTrainer(WortListe liste) {
        this.liste = liste;
    }

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
        return this.liste.eintragAt(this.selected);
    }

    /**
     * Überprüft, ob das Wort des aktuell ausgewählten Worteintrages mit dem übergebenen Wort
     * übereinstimmt. Dabei wird auf dieselben Kriterien (bzgl. Länge) geachtet wie in der Klasse
     * 'asuender.WortEintrag'.
     * @param wort Wort, welches verglichen werden soll
     * @return true, wenn die Wörter übereinstimmten, sonst false
     */
    public boolean check(String wort) {
        if (wort.trim().length() < 2 || wort == null) {
            throw new IllegalArgumentException("Das Wort muss mind. 2 Buchstaben lang sein!");
        }

        return this.getSelected().getWort().equals(wort);
    }

    /**
     * Wie die 'check'-Methode oben, diese achtet hier aber nicht auf die Groß- und Kleinschreibung.
     * @param wort Wort, welches verglichen werden soll
     * @return true, wenn die Wörter übereinstimmten, sonst false
     */
    public boolean checkIgnoreCase(String wort) {
        if (wort.trim().length() < 2 || wort == null) {
            throw new IllegalArgumentException("Das Wort muss mind. 2 Buchstaben lang sein!");
        }

        return this.getSelected().getWort().equalsIgnoreCase(wort);
    }
}
