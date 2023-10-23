/**
 * Diese Klasse stellt Funktionen zum Berechnen einzelner Dinge bei einer Raute bereit.
 * @author Andreas Suender
 * @version 2020-03-16
 */
public class RautenFormeln {
    /**
     * Diese Methode errechnet sich die Seitenlänge einer Raute aus den Diagonalen.
     * @param e Diagonale e
     * @param f Diagonale f
     * @return Seitenlänge a
     */
    public static double seite(double e, double f) {
        double a = Math.pow(e/2, 2) + Math.pow(f/2, 2);
        a = Math.sqrt(a);
        return a;
    }

    /**
     * Diese Methode errechnet sich den Umfang einer Raute aus den Diagonalen.
     * @param e Diagonale e
     * @param f Diagonale f
     * @return Umfang U
     */
    public static double umfang(double e, double f) {
        double a = Math.sqrt(Math.pow(e/2, 2) + Math.pow(f/2, 2));
        return 4*a;
    }

    /**
     * Diese Methode errechnet sich den Flächeninhalt aus den Diagonalen.
     * @param e Diagonale e
     * @param f Diagonale f
     * @return Flächeninhalt A
     */
    public static double flaeche(double e, double f) {
        return (e*f)/2;
    }
}