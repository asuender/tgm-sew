/**
 * Rechnen
 * 
 * Diese Klasse enthält eine Methode zum Addieren, Subtrahieren, Multiplizieren bzw. Divideren von zwei Dezimalzahlen.
 * @author Andreas Suender
 * @version 2020-05-07
 */
public class Rechen {

    /**
     * Diese Methode nimmt zwei Parameter a und b auf + einem Operator. Je nach Operator werden a und b multipliziert, addiert,
     * dividiert oder subtrahiert. Besonderheit: werden b=0 & m=/ angegeben, so ist der Rückgabewert 0.
     * @param a erste Dezimalzahl
     * @param b zweite Dezimalzahl
     * @param m Operator
     * @return Ergebnis von a [ + - * / ] b
     */
    public static double rechnen(double a, double b, char m) {
        double res = 0.0;

        switch(m) {
            case '+':
                res=a+b;
                break;
            case '-':
                res=a-b;
                break;
            case '*':
                res=a*b;
                break;
            case '/':
                if (b == 0.0)
                    res=0.0;
                else
                    res=a/b;
                break;
        }
        return res;
    }
}