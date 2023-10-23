import javax.swing.JOptionPane;

/**
 * Der Benutzer wird aufgefordert, zwei Dezimalzahlen und einen Rechenoperator einzugeben. Je nachdem, was er als diesen eingibt,
 * werden die zwei Zahlen addiert, subtrahiert, dividert oder multipliziert. Wird ein ungültiger Operator eingegeben, so
 * wird die Eingabe so lange wiederholt, bis alles passt.
 * @author Andreas Suender
 * @version 2020-05-07
 */
public class RechenEingabe {
    /**
     * Der Benutzer wird aufgefordert, zwei Dezimalzahlen und einen Rechenoperator einzugeben. Je nachdem, was er als diesen eingibt,
     * werden die zwei Zahlen addiert, subtrahiert, dividert oder multipliziert. Wird ein ungültiger Operator eingegeben, so
     * wird die Eingabe so lange wiederholt, bis alles passt. 
     * @param args not used
     */
    public static void main(final String[] args) {
        boolean valid;

        final double a =  Double.parseDouble(JOptionPane.showInputDialog(null, "Bitte eine Dezimalzahl eingeben"));
        final double b =  Double.parseDouble(JOptionPane.showInputDialog(null, "Bitte eine weitere Dezimalzahl eingeben"));
        char m;  

        do {
            m =  JOptionPane.showInputDialog(null, "Bitte (nochmals) eine Rechenmethode angeben ( +, -, *, / )").charAt(0);
            switch(m) {
                case '+':
                case '-':
                case '*':
                case '/':
                    valid=true;
                    break;
                default:
                    valid=false;
            }
        } while(valid==false);

        JOptionPane.showMessageDialog(null, String.format("Das Ergebnis von %f %c %f = %f", a, m, b, Rechen.rechnen(a, b, m)));
    }

}