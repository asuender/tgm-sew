import java.util.Random;

/**
 * Diese Klasse enthält einfache Methoden zum Erzeugen
 * von ganzzahligen Zufallszahlen.
 * @author Andreas Suender
 * @version 21-09-2020
 */
public class Zufallszahlen {
    /**
     * Erzeugt eine ganzzahligen Zufallszahl zwischen 1 und 10.
     * @return erzeugte Zufallszahl
     */
    public static int zufall() {
        Random r = new Random();
        return r.nextInt(10)+1;
    }
    
    /**
     * Erzeugt eine ganzzahligen Zufallszahl zwischen 1 und der Obergrenze 'max'.
     * @param max Obergrenze
     * @return erzeugte Zufallszahl
     */
    public static int zufall(int max) {
        Random r = new Random();
        return r.nextInt(max)+1;
    }
    
    /**
     * Erzeugt eine ganzzahlige Zufallszahl zwischen der benutzerdefinierten
     * Unter- und Obergrenze.
     * @param min Untergrenze
     * @param max Obergrenze.
     * @return erzeugte Zufallszahl
     */
    public static int zufall(int min, int max) {
        Random r = new Random();
        return r.nextInt(max)+min;
    }
}
