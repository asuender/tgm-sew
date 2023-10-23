import javax.swing.JOptionPane;

/**
 * Der Benutzer gibt ein gültiges Datum ein und erhält eine getrennte Ausgabe von Tag, Monat und Jahr.
 * @author Andreas Suender
 * @version 2020-04-16
 */
public class Analyse {
    /**
     * Der Benutzer gibt ein gültiges Datum ein und erhält eine getrennte Ausgabe von Tag, Monat und Jahr.
     * @param args not used
     */
    public static void main(String[] args) {
        // Eingabe
        String date = JOptionPane.showInputDialog(null, "Bitte ein gültiges Datum im Format 't.m.jjjj' eingeben:");
        // Formatierte Ausgabe
        JOptionPane.showMessageDialog(null,
             "Tag: "   +  Datum.tag(date)   + "\n" +
             "Monat: " +  Datum.monat(date) + "\n" +
             "Jahr: "  +  Datum.jahr(date)  + "\n"
        );
    }
}