import javax.swing.JOptionPane;

/**
 * Palindromtest
 */
public class Palindromtest {

    public static void main(String[] args) {
        // Eingabe
        String palindrom = JOptionPane.showInputDialog(null, "Bitte einen Text eingeben:");
        // Ausgabe schon einmal vorher festlegen
        String message = "Dieser Text ist leider kein Palindrom!";
        if (Textanalyse.istPalindrom(palindrom) == true)
            message = "Dieser Text ist ein Palindrom!";
        // Ausgabe
        //JOptionPane.showMessageDialog(null, message);
        System.out.println(Textanalyse.istPalindrom("Eisenbahn"));
    }
}