import java.lang.Math;

/**
 * Diese Klasse enthält eine Methode, die eine Zufallszahl zwischen 1 und 10 berechnet.
 * @author Andreas Suender
 * @version 2020-03-11
 */
public class Zufall
{
    /**
     * Diese Methode berechnet eine Zufallszahl zwischen 1 und 10 und gibt sie als 'int' zurück.
     * Sie ist besonders kurz gehalten.
     * @return Zufallszahl zwischen 1 und 10
     */
    public static int zufall1Bis10() {
        return (int)(Math.random()*10+1);
    }
}