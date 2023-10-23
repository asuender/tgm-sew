import javax.swing.JOptionPane;

/**
 * Der Benutzer muss einen Text und ein Zeichen eingeben, dass in dem Text gesucht werden soll.
 * Wird dieses gefunden, so wird eine Erfolgsmeldung ausgegeben.
 * @author Andreas Suender
 * @version 2020-04-14
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
        char c = JOptionPane.showInputDialog(null, "Bitte das Zeichen eingeben, das gesucht werden soll:").charAt(0);
        int result = Textanalyse.suchen(text, c);
        if (result != -1)
            // String.format() ist viel schöner:
            JOptionPane.showMessageDialog(null, String.format("Das Zeichen '%c' wurde im Text '%s' an der Stelle %d gefunden", c, text, result));
        else JOptionPane.showMessageDialog(null, "Konnte das Zeichen nicht finden.");
    }
}