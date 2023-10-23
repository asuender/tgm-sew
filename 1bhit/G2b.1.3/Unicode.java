import javax.swing.JOptionPane;

/**
 * Der Benutzer muss ein einzelnes Zeichen eingeben. Diesed wird dann in ein 'char' umgewandelt
 * und inklusive des Unicode-Wertes ausgegeben.
 * @author Andreas Suender
 * @version 2020-03-27
 */
public class Unicode {
    /**
     * Der Benutzer muss ein einzelnes Zeichen eingeben. Diesed wird dann in ein 'char' umgewandelt
     * und inklusive des Unicode-Wertes ausgegeben.
     * @param args not used.
     */
    public static void main(String[] args) {
        // Eingabe + Umwandlung
        char userInput = JOptionPane.showInputDialog(null, "Bitte ein einzelnes Zeichen eingeben:").charAt(0);
        // Ausgabe des Zeichen + Unicode-Wert
        JOptionPane.showMessageDialog(null, "Das Zeichen "+userInput+" hat laut der Unicode-Tabelle den Wert "+(int)userInput+".");
    }
}