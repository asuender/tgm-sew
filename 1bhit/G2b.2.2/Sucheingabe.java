import javax.swing.JOptionPane;

/**
 * Der Benutzer muss einen Text und ein Zeichen eingeben, dass in dem Text gesucht werden soll.
 * Wird dieses gefunden, so wird eine Erfolgsmeldung ausgegeben.
 * @author Andreas Suender
 * @version 2020-04-20
 */
public class Sucheingabe {
    /**
     * Der Benutzer muss einen Text und ein Zeichen eingeben, dass in dem Text gesucht werden soll.
     * Wird dieses gefunden, so wird eine Erfolgsmeldung ausgegeben.
     * @param args not used
     */
    public static void main(String[] args) {
        // Benutzereingaben
        String text = JOptionPane.showInputDialog(null, "Bitte einen Text eingeben:");
        char c = JOptionPane.showInputDialog(null, "Bitte das Zeichen eingeben, in dem Text untersucht werden soll:").charAt(0);
        int index = Textanalyse.suchen(text, c);
        int index2 = Textanalyse.sucheGrossKlein(text, c);
        int count = Textanalyse.zaehleBuchstabe(text, c);
        int lowest = Textanalyse.kleinsterBuchstabe(text);
        int greatest = Textanalyse.groessterBuchstabe(text);
        String message;
        if (index != -1) {
            // String.format() ist viel schöner:
            message = String.format("Das Zeichen '%c' wurde im Text '%s' an der Stelle %d gefunden und kommt insgesamt %d-Mal vor.", c, text, index, count);                               
        }
        else message = "Konnte das Zeichen nicht finden.";

        message += String.format("\nBeachtet man nicht die Groß-und Kleinschreibung, so findet man das eingegebene Zeichen an der Stelle %d.", index2);
        message += String.format("\nDer kleinste Buchstabe in diesem Text ist %c und befindet sich an der Stelle %d.", text.charAt(lowest), lowest);
        message += String.format("\nDer groesste Buchstabe hingegen ist %c an der Stelle %d.", text.charAt(greatest), greatest);
        JOptionPane.showMessageDialog(null, message);
    }
}