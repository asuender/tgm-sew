/**
 * Diese Klasse wird dafür verwendet, um ein Rechteck zu zeichnen. Die erste Methode 'zeile' zeichnet nur eine einzelne Zeile,
 * 'rechteck' übernimmt die ganze Zeichnung, wobei sie sich an 'zeile' bedient.
 * @author Andreas Suender
 * @version 2020-03-07
 */
public class Muster {
    /**
     * Diese Methode schreibt nur eine einzelne Zeile in die Konsole.
     * @param zeichen Zeichen, mit dem das Rechteck gefüllt werden muss.
     * @param zahl Anzahl der Zeichen in einer Zeile.
     * @return ganze Zeile als Text.
     */
    public static String zeile(String zeichen, int zahl) {
        String zeile = "";
        for (int i = 0; i < zahl; i++)
            zeile += zeichen;
        return zeile+"\n";
    }

    /**
     * Diese Methode schreibt ein ganzes Rechteck in die Konsole. Für jede Zeile wird die Methode 'zeile' verwendet.
     * @param zeichen Zeichen, mit dem das Rechteck gefüllt werden muss.
     * @param hoehe Anzahl der Zeilen.
     * @param breite Anzahl der Zeichen in einer Zeile.
     * @return ganzes Rechteck als Text.
     */
    public static String rechteck(String zeichen, int hoehe, int breite) {
        String rechteck = "";
        String tmp = "";
        for (int i = 0; i < hoehe; i++)
            tmp = Muster.zeile(zeichen, breite);
            rechteck += tmp; 
        return rechteck;
    }
}