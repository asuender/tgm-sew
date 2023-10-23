/**
 * Die Klasse Textanalyse beinhaltet verschiedenste Funktionen, um in einem Text etwas zu suchen.
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

    /**
     * Wie 'suchen()', aber Groß-bzw. Kleinschreibung wird hier nicht beachtet.
     * @param text String, in dem gesucht werden soll
     * @param c Zeichen, das gefunden werden soll
     * @return Index, wenn gefunden, sonst -1
     */
    public static int sucheGrossKlein(String text, char c) {
        int index = -1;
        int act_index;
        // Text + Zeichen müssen ja umgewandelt werden
        text.toLowerCase(); Character.toLowerCase(c);
        for (act_index=0; act_index<text.length(); act_index++) {
            if (c == text.charAt(act_index)) {
                index=act_index;
                break;
            }
        }
        return index;
    }

    /**
     * Diese Methode zählt die Anzahl der Vorkommnisse des Zeichens c in dem String text.
     * @param text String, in dem gezählt werden soll
     * @param c Zeichen, dessen Anzahl festgestellt werden soll
     * @return
     */
    public static int zaehleBuchstabe(String text, char c) {
        int count = 0;
        for (int act_index=0; act_index<text.length(); act_index++) {
            if (c == text.charAt(act_index)) {
                ++count;
            }
        }
        return count; 
    }

    /**
     * Diese Methode sucht den kleinsten Buchstaben in einem Text und gibt den Index von diesem zurück.
     * @param text String, in dem gesucht werden soll
     * @return Index des kleinsten Buchstaben
     */
    public static int kleinsterBuchstabe(String text) {
        int greatest = (int)Character.toLowerCase(text.charAt(0));
        int act_letter;
        int index = 0;
        text.toLowerCase();
        for (int act_index=0; act_index<text.length(); act_index++) {
            act_letter = (int)Character.toLowerCase(text.charAt(act_index));
            if (act_letter<greatest) {
               index = act_index;
            }
        }
        return index;
    }

    /**
     * Diese Methode sucht den kleinsten Buchstaben in einem Text und gibt den Index von diesem zurück.
     * @param text String, in dem gesucht werden soll
     * @return Index des kleinsten Buchstaben
     */
    public static int groessterBuchstabe(String text) {
        int greatest = (int)Character.toLowerCase(text.charAt(0));
        int act_letter;
        int index = 0;
        text.toLowerCase();
        for (int act_index=0; act_index<text.length(); act_index++) {
            act_letter = (int)Character.toLowerCase(text.charAt(act_index));
            if (act_letter>greatest) {
               index = act_index;
            }
        }
        return index;
    }

    /**
     * Diese Methode testet einen String, ob dieser ein Palindrom ist oder nicht (Wort & Satz).
     * @param text String, der geprüft werden soll
     * @return true (String is Palindrom); false (String ist kein Palindrom)
     */
    public static boolean istPalindrom(String text) {
        boolean result = false;
        String textNoSymbols = "";
        String inversed = "";
        text = text.toLowerCase();
        char c;

        // String 'text' kopieren, ohne Satzzeichen
        for (int i=0; i<text.length(); i++) {
            c=text.charAt(i);
            if (c!=' ' && c!= '.' && c!=',' && c!=';' && c!='!' && c!='?')
                textNoSymbols+=c;
        }

        // String umkehren (ohne Satzzeichen)
        for (int i=text.length()-1; i>=0; i--) {
            c=text.charAt(i);
            if (c!=' ' && c!= '.' && c!=',' && c!=';' && c!='!' && c!='?')
                inversed+=c;
        }
            
        // Überprüfen, ob 'text' und 'textNoSymbols' gleich sind
        if (textNoSymbols.equals(inversed))
            result = true;

        return result;
    }
}