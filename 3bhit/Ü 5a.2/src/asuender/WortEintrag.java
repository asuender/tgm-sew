package asuender;

/**
 * Diese Klasse speichert einen Eintrag, bestehend aus einem Wort und einer URL.
 * Gedacht für den Rechtschreibtrainer.
 * @author Andreas Suender
 * @version 09-19-2021
 */
public class WortEintrag {
    private String wort, url;

    public WortEintrag() {}

    /**
     * Initalisiert ein asuender.WortEintrag-Objekt, wobei das Wort (ohne Leer- und Sonderzeichen) mind.
     * 2 Zeichen lang sein muss. Für die URL gibt es änhliche Einschränkungen.
     * @param wort Wort, welches gespeichert werden soll
     * @param url URL, welche gespeichert werden soll
     */
    public WortEintrag(String wort, String url) {
        if (wort.trim().length() < 2 || wort == null) {
            throw new IllegalArgumentException("Das Wort muss mind. 2 Buchstaben lang sein!");
        }

        if (url == null) throw new NullPointerException("Die URL darf kein Nullobjekt sein!");

        this.wort = wort;
        this.url = url;
    }

    /**
     * Gibt das gespeicherte Wort zurück.
     * @return das gespeicherte Wort
     */
    public String getWort() {
        return wort;
    }

    /**
     * Setzt das Wort, wobei das Wort (ohne Leer- und Sonderzeichen) mind.
     * 2 Zeichen lang sein muss.
     * @param wort Wort, welches gesetzt werden soll.
     */
    public void setWort(String wort) {
        if (wort.trim().length() < 2 || wort == null) {
            throw new IllegalArgumentException("Das Wort muss mind. 2 Buchstaben lang sein!");
        }

        this.wort = wort;
    }

    /**
     * Gibt die gespeicherte URL zurück.
     * @return die gespeicherte URL
     */
    public String getUrl() {
        return url;
    }

    /**
     * Setzt die URL. Dabei wird darauf geachtet, dass der übergebene Wert kein Nullobjekt ist.
     * @param url URL, welche gespeichert werden soll
     */
    public void setUrl(String url) {
        if (url == null) throw new NullPointerException("Die URL darf kein Nullobjekt sein!");

        this.url = url;
    }

    /**
     * Überprüft eine übergebene URL auf folgende Kriterien:
     *  - 'http://' oder 'https://' steht am Anfang
     *  - nach dem Protokoll soll mindestens 1 Buchstabe stehen ...
     *  - ... gefolgt von einem Punkt ...
     *  - ... und wieder mindestens einem Buchstaben.
     * Hierbei wird ein selbst erstelltes Regex verwendet.
     * Nullobjekte werden nicht akzeptiert.
     * @param url Die URL, welche geprüft werden soll
     * @return true, wenn die URL den obigen Kriterien entspricht, andernfalls false
     */
    public static boolean checkURL(String url) {
        if (url == null) throw new NullPointerException("Die URL darf kein Nullobjekt sein!");

        return url.matches("^https?://[a-zA-Z]+\\.[a-zA-Z]+");
    }

    /**
     * Formatiert die intern gespeicherten Attribute ('wort' und 'url') im Format '[wort];[url]'
     * und gibt diese als String zurück.
     * @return den formatierten String
     */
    @Override
    public String toString() {
        return String.format("%s;%s", this.wort, this.url);
    }
}
