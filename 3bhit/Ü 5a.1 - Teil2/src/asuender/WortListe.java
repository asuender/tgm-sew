package asuender;

/**
 * Diese Klasse speichert eine Liste aus Einträgen.
 * Gedacht für den Rechtschreibtrainer.
 * @author Andreas Suender
 * @version 09-19-2021
 */
public class WortListe {
    private WortEintrag[] eintraege;
    private int length;

    /**
     * Initalisiert eine neue Wortliste. Dabei wird auch darauf geachtet, dass das
     * übergebene Array kein Nullobjekt ist.
     * @param eintraege Wortliste, welche gespeichert werden soll
     */
    public WortListe(WortEintrag[] eintraege) {
        if (eintraege == null) throw new NullPointerException("Das Array darf kein Nullobjekt sein!");

        this.eintraege = eintraege;
        this.length = eintraege.length;
    }

    /**
     * Gibt die Länge der gespeicherten Wortliste zurück.
     * @return Länge der Wortliste
     */
    public int getLength() {
        return length;
    }

    /**
     * Fügt den mitgegebenen Worteintrag in die bestehende Wortliste hinzu bzw. erweitert sie ggf.
     * Nullobjekte sind nicht erlaubt.
     * @param eintrag Eintrag, welche in die Wortliste hinzugefügt werden soll
     */
    public void addEntry(WortEintrag eintrag) {
        if (eintrag == null) throw new NullPointerException("Der hinzuzufügende Eintrag darf kein Nullobjekt sein!");

        WortEintrag[] tmp = new WortEintrag[this.eintraege.length+1];

        if (this.eintraege.length != 0) {
            for (int i = 0; i < eintraege.length; i++) {
                tmp[i] = this.eintraege[i];
            }
        }

        tmp[tmp.length-1] = eintrag;
        this.eintraege = tmp;

        this.length += 1;
    }

    /**
     * Ähnlich wie die {@code String.charAt()} - Methode, gibt sie den Eintrag am mitgegebenen Index zurück.
     * Dabei wird auch darauf geachtet, dass 'index' im gültigen (sinnvollen) Bereich liegt.
     * @param index Index in der Wortliste, an welcher ein Eintrag gesucht und zurückgegeben wird.
     * @return Eintrag an der Stelle 'index'
     */
    public WortEintrag eintragAt(int index) {
        if (index < 0 || index >= this.eintraege.length) throw new IndexOutOfBoundsException("Liste ist leer od. der Index außerhalb des gültigen Bereiches!");

        return this.eintraege[index];
    }

    /**
     * Sucht nach dem 1. Eintrag, dessen Wort dem übergebenen Wert entspricht.
     * Dabei wird der Parameter (wie auch in der Klasse 'asuender.WortEintrag') auf die entsprechende Sinnhaftigkeit überprüft.
     * Sollte die Liste leer sein, wird keine Exception ausgelöst.
     * @param wort Wort, mit dem der zu löschende Eintrag gesucht werden soll
     * @return true, wenn das Vorhaben erfolgreich war, andernfalls false
     */
    public boolean deleteEintrag(String wort) {
        if (wort.trim().length() < 2 || wort == null) {
            throw new IllegalArgumentException("Das Wort muss mind. 2 Buchstaben lang sein!");
        }

        boolean successful = false;

        for (int i=0; i<this.eintraege.length; i++) {
            if (this.eintraege[i].getWort().equals(wort)) {
                this.eintraege[i] = null;
                successful = true;
                this.length -= 1;
                break;
            }
        }
        return successful;
    }

    /**
     * Löscht die interne Liste.
     */
    public void loescheListe() {
        this.eintraege = new WortEintrag[]{}; // kein 'null'. Böse.
        this.length = 0;
    }

    /**
     * Kombiniert alle Elemente der Wortliste in einem String (ein Eintrag pro Zeile) und gibt diesen zurück.
     * Eine leere Liste führt nicht zu einer Exception.
     * @return Textform der Wortliste
     */
    @Override
    public String toString() {
        String result = "";

        for (WortEintrag eintrag : this.eintraege) {
            if (eintrag == null) continue;
            result += eintrag + "\n"; // ruft wieder .toString() auf
        }

        return result;
    }
}
