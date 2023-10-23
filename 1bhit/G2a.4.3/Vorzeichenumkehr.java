import javax.swing.JOptionPane;

/**
 * Der Benutzer muss mehrmals ganze Zahlen eingeben, wobei das Vorzeichen dieser Zahl dann umgedreht und das Ergebnis dann ausgegeben wird.
 * Das geht so lange, bis die Zahl 0 wird.
 * @author Andreas Suender
 * @version 2020-03-16
 */
public class Vorzeichenumkehr {
    public static void main(String[] args) {
        // Deklaration
        int number;

        do {
            number = Integer.parseInt(JOptionPane.showInputDialog(null, "Bitte eine Zahl eingeben."));
            // die Zahl wird einfach mit -1 multipliziert, fertig zum Ausgeben
            JOptionPane.showMessageDialog(null, "Ergebnis: "+number*-1);
        }
        while(number != 0);
    }
}