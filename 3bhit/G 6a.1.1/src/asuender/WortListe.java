package asuender;

import java.util.*;

/**
 * Diese Klasse speichert eine Liste aus Einträgen.
 * Gedacht für den Rechtschreibtrainer.
 * @author Andreas Suender
 * @version 09-19-2021
 */
public class WortListe {
    private LinkedList<WortEintrag> eintraege;
    private int length;

    public WortListe() {
        this.eintraege = new LinkedList<>();
    }

    /**
     * Initialisiert eine neue Wortliste. Dabei wird auch darauf geachtet, dass das
     * übergebene Array kein Nullobjekt ist.
     * @param eintraege Wortliste, welche gespeichert werden soll
     */
    public WortListe(List<WortEintrag> eintraege) {
        if (eintraege == null) throw new NullPointerException("Das Array darf kein Nullobjekt sein!");

        this.eintraege = new LinkedList<>(eintraege);
        this.length = eintraege.size();
    }

    /**
     * Gibt die intern gespeicherte Wortliste als Array zurück.
     * @return intern gespeicherte Wortliste
     */
    public LinkedList<WortEintrag> getEintraege() {
        return eintraege;
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

        this.eintraege.add(eintrag);
        ++this.length;
    }

    /**
     * Ähnlich wie die {@code String.charAt()} - Methode, gibt sie den Eintrag am mitgegebenen Index zurück.
     * Dabei wird auch darauf geachtet, dass 'index' im gültigen (sinnvollen) Bereich liegt.
     * @param index Index in der Wortliste, an welcher ein Eintrag gesucht und zurückgegeben wird.
     * @return Eintrag an der Stelle 'index'
     */
    public WortEintrag eintragAt(int index) {
        if (index < 0 || index >= this.eintraege.size()) throw new IndexOutOfBoundsException("Liste ist leer od. der Index außerhalb des gültigen Bereiches!");

        return this.eintraege.get(index);
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

        if (this.eintraege.removeIf(eintrag -> eintrag.getWort().equals(wort))) {
            --this.length;
            return true;
        }

        return false;
    }

    /**
     * Löscht die interne Liste.
     */
    public void loescheListe() {
        this.eintraege = new LinkedList<>();
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

        return result.substring(0, result.length()-1); // entfernt das letzte Newline
    }

    /* === NEUE METHODEN === */

    /**
     * Berechnet den Durchschnitt der Länge aller gespeicherten Wörter;
     * @return Integer > 0, wenn Elemente vorhanden sind, sonst -1
     */
    public double averageWordLength() {
        OptionalDouble average = this.eintraege.stream().mapToDouble(e -> e.getWort().length()).average();

        if (average.isPresent()) {
            return average.getAsDouble();
        } else {
            return -1;
        }
    }

    /**
     * Löscht dann in der Methode alle Wörter, die kürzer als die angegebene Länge sind.
     * @param len Länge, die zum Filtern verwendet werden soll
     */
    public void filter(int len) {
        Iterator<WortEintrag> it = this.eintraege.iterator();
        WortEintrag eintrag;
        while (it.hasNext()) {
            eintrag = it.next();
            if (eintrag.getWort().length() < len) {
                this.deleteEintrag(eintrag.getWort());
            }
        }
    }
}
