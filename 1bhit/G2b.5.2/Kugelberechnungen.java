import java.lang.Math;

/**
 * Diese Klasse enthält Methoden zum Berechnen von Oberfläche, Durchmesser und Volumen einer Kugel.
 * Jede dieser Methoden verlangt einen Parameter, nämlich den Radius.
 * @author Andreas Suender
 * @version 2020-06-16
 */
public class Kugelberechnungen {
    /**
     * Berechnet den Durchmesser anhand des Radius.
     * @param radius Radius
     * @return Durchmesser
     */
    public static double durchmesser(double radius) {
        return radius*2;
    }

    /**
     * Berechnet die Oberfläche einer Kugel anhand des Radius.
     * @param radius Radius
     * @return Oberfläche
     */
    public static double oberflaeche(double radius) {
        return 4*Math.PI*radius*radius;
    }

    /**
     * Berechnet das Volumen einer Kugel anhand des Radius.
     * @param radius Radius
     * @return Volumen
     */
    public static double volumen(double radius) {
        return (4/3.0)*Math.PI*Math.pow(radius, 3);
    }
}