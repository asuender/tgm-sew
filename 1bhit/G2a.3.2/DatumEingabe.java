import javax.swing.JOptionPane;

/**
 * Der Benutzer wird dazu aufgefordert, eine Jahreszahl einzugeben, die daraufhin überprüft wird,
 * ob sie ein Schaltjahr ist. Dazu wird die Methode aus der Klasse 'Datum' verwendet.
 * @author Andreas Suender
 * @version 2020-03-03
 */
public class DatumEingabe {
    /**
     * Der Benutzer wird dazu aufgefordert, eine Jahreszahl einzugeben, die daraufhin überprüft wird,
     * ob sie ein Schaltjahr ist. Dazu wird die Methode aus der Klasse 'Datum' verwendet.
     * @author Andreas Suender
     * @version 2020-03-03
     */
    public static void main(String[] args) {
        // Eingabe der Jahreszahl
        int eingabeJahr  = Integer.parseInt(JOptionPane.showInputDialog(null, "Bitte geben Sie ein Jahr ein, das überprüft werden soll."));
        
        // Ausgabe
        if (Datum.istSchaltjahr(eingabeJahr)) JOptionPane.showMessageDialog(null, "Das eingegebene Jahr ist ein Schaltjahr!");
        else { JOptionPane.showMessageDialog(null, "Das eingegebene Jahr ist kein Schaltjahr!"); }
    }
}