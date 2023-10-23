import javax.swing.JOptionPane;

/**
 * Der Benutzer wird aufgefordert, eine Zahl einzugeben, die dann in römische Ziffern umgewandelt wird. Das Ergebnis wird in die Konsole geschrieben.
 * @author Andreas Suender
 * @version 2020-03-07
 */
public class ZahlEingabe  {
    public static void main(String[] args) {
        // Nicht besonders spannend...
        int zahl = Integer.parseInt(JOptionPane.showInputDialog(null, "Bitte eine Zahl eingeben."));
        System.out.println(Umwandeln.roemer(zahl));
    }
}