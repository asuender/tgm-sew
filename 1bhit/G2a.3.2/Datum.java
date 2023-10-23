/**
 * In dieser Klasse steht die Methode 'istSchaltjahr', die dazu verwendet werden kann, um
 * eine Jahreszahl auf ein mögliches Schaltjahr zu überprüfen.
 * @author Andreas Suender
 * @version 2020-03-03
 */
public class Datum {
    /**
     * Diese Methode überprüft die Jahreszahl (Parameter), ob sie ein Schaltjahr ist und gibt entweder
     * true oder false zurück.
     * @param jahr Jahreszahl
     * @return boolean, ob die Jahreszahl ein Schaltjahr ist.
     */
    public static boolean istSchaltjahr(int jahr) {
        // vorherige Deklaration der Rückgabevariable vereinfacht den Programmaufbau.
        boolean schaltjahr = false;

        if ( (jahr%4 == 0 || jahr%400 == 0) && jahr%100 != 0) schaltjahr = true;
        return schaltjahr;
    }
}