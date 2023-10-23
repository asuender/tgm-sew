/**
 * Zeichentools
 * Diese Klasse enthält eine Methode zum Bearbeiten von Strings.
 * @author Andreas Suender
 * @version 2020-03-30
 */
public class Zeichentools {
    /**
     * Diese Methode teilt fügt zwischen alle Zettel in s auf und fügt zwischen ihnen ein Komma ein.
     * @param s Input-String zum Auftrennen
     * @return Bearbeiteter String
     */
    public static String trenne(String s) {
        String result = "";
        for (int i=0; i<s.length(); i++) {
            result += (i==s.length()-1) ? s.charAt(i) : s.charAt(i)+",";
        }
        return result;
    }   
}