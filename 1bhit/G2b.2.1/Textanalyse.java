/**
 * Die Klasse Textanalyse beinhaltet die Funktion 'suchen',
 * die es ermöglicht, ein Zeichen in einem String zu suchen.
 * @author Andreas Suender
 * @version 2020-04-14
 */
public class Textanalyse {
    /**
     * Diese Methode nimmt ein Zeichen c auf und sucht dieses in dem String text.
     * Wird dieses gefunden, gibt sie den Index im String zurück, andernfalls -1.
     * @param text String, in dem gesucht werden soll
     * @param c Zeichen, das gefunden werden soll
     * @return Index, wenn gefunden, sonst -1
     */
    public static int suchen(String text, char c) {
        int index = -1;
        int act_index;
        // Schleife besonders kurz gehalten
        for (act_index=0; act_index<text.length(); act_index++) {
            if (text.charAt(act_index) == c) {
                index=act_index;
                break;
            }
        }
        return index;
    }
}