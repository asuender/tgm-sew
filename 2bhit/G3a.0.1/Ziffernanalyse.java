
/**
 * Diese Klasse enthält Methoden, um Ziffern (0-9) aus einem Text zu
 * zählen bzw. filtern.
 *
 * @author Andreas Sünder
 * @version 2020-09-15
 */
public class Ziffernanalyse
{
	/**
	 * Zählt die Ziffern aus einem String.
	 * @param text Ausgangstext
	 * @return Anzahl der Ziffern
	 */
    public static int ziffernZaehlen (String text) {
        int counter = 0;
        for (int i=0; i<text.length(); i++) {
            if (text.charAt(i) >= '0' && text.charAt(i) <= '9')
                counter++;
        }
        return counter;
    }
    
    /**
     * Zählt, wie oft die mitgegebene Ziffer im Text vorkommt.
     * @param text Ausgangstext
     * @param num Ziffer, dessen Vorkommnisse gezählt werden soll
     * @return Anzahl der Treffer
     */
    public static int ziffernZaehlen (String text, int num) {
		int counter = 0;
        for (int i=0; i<text.length(); i++) {
            if (text.charAt(i) == num+'0')
                counter++;
        }
        return counter;
    }
    
   	/**
	 * Filtert die Ziffern aus einem String.
	 * @param text Ausgangstext
	 * @return gefilterte Ziffern bzw. "Keine Ziffer vorhanden!", falls keine gefunden wurde.
	 */
    public static String ziffernFiltern(String text) {
        String res = "Keine Ziffer vorhanden!";
        char c;
        if (ziffernZaehlen(text) != 0) {
            res = "";
            for (int i=0; i<text.length(); i++) {
                c = text.charAt(i);
                res += (c >= '0' && c <= '9') ? c : "";
            }
            res+=" sind die gefilterten Ziffern.";
        }
        return res;
    }
}
