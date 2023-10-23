import javax.swing.JOptionPane;

/**
 * Test
 * 
 * Der Benutzer kann mit diesem Programm beliebige Texte ver- und entschlüsseln.
 * @author Andreas Suender
 * @version 2020-05-12
 */
public class Test {

    public static void main(String[] args) {
        String input  = JOptionPane.showInputDialog(null, "Bitte einen Text zum Verschlüsseln angeben.");
        int shift     = Integer.parseInt(JOptionPane.showInputDialog(null, "Bitte eine Zahl zum Verschieben eingeben:"));
        char displace = JOptionPane.showInputDialog(null, "Bitte ein Zeichen eingeben, zu dem verschoben werden soll:").charAt(0);
        String decr_caesar  = Verschluesselung.verschluesseln(input);
        String decr_shift   = Verschluesselung.verschluesseln(input, shift);
        String decr_deplace = Verschluesselung.verschluesseln(input, displace);

        JOptionPane.showMessageDialog(null, String.format("Ihr Text: %s\nCaesar-verschlüsselt: %s\nVerschlüsselt mit %d-er Verschiebung: %s\nVerschoben zu %c: %s\nEntschlüsselt (mit Caesar): %s\nEntschlüsselt mit %d-er Verschiebung: %s\nEntschlüsselt (verschoben zu %c): %s", 
            input,
            decr_caesar,
            shift,
            decr_shift,
            displace,
            decr_deplace,
            Verschluesselung.entschluesseln(decr_caesar),
            shift,
            Verschluesselung.entschluesseln(decr_shift, shift),
            displace,
            Verschluesselung.entschluesseln(decr_deplace, displace))
        );
        
    }
}