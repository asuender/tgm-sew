import javax.swing.JOptionPane;

/**
 * Der Benutzer wird gefragt, eine römische Zahl einzugeben. Diese wird in eine Dezimalzahl umgwandelt und ausgegeben.
 * @author Andreas Suender
 * @version 2020-05-07
 */
public class RoemerEingabe {
    public static void main(String[] args) {
        String rz = JOptionPane.showInputDialog(null, "Bitte eine römische Zahl eingeben:");
        JOptionPane.showMessageDialog(null, String.format("Die Umwandlung von %s in eine Zahl ist: %d", rz, Roemer.reomer(rz)));
    }
}