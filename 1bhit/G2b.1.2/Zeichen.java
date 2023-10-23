import javax.swing.JOptionPane;

/**
 * Der Benutzer muss ein 'J', 'j', 'N' oder ein 'n' eingeben. Je nachdem, was er eingibt, kommt nachr
 * die Meldung "Du hast j oder J für Ja eingegeben." bzw. "Du hast n oder N für Nein eingegeben.".
 * Gibt er etwas anderes sein, erscheint "Das Zeichen ist unbekannt.".
 * @author Andreas Suender
 * @version 2020-03-27
 */
public class Zeichen {
    /**
     * Der Benutzer muss ein 'J', 'j', 'N' oder ein 'n' eingeben. Je nachdem, was er eingibt, kommt nachr
     * die Meldung "Du hast j oder J für Ja eingegeben." bzw. "Du hast n oder N für Nein eingegeben.".
     * Gibt er etwas anderes sein, erscheint "Das Zeichen ist unbekannt.".
     * @author Andreas Suender
     * @version 2020-03-27
     * @param args not used.
     */
    public static void main(String[] args) {
        char userInput = JOptionPane.showInputDialog(null, "Bitte J, j; N oder n eingeben:").charAt(0); // das erste Zeichen als 'char' speichern 
        String message; // Text wird in unterschiedlichen Fällen hier gespeichert.

        if (userInput == 'J' || userInput == 'j')
            message = "Du hast j oder J für Ja eingegeben.";
        else if (userInput == 'N' || userInput == 'n')
            message = "Du hast n oder N für Nein eingegeben.";
        else
            message = "Das Zeichen ist unbekannt.";
        
        // Ausgabe
        JOptionPane.showMessageDialog(null, message);
    }
}