import javax.swing.JOptionPane;

/**
 * Der Benutzer muss in zwei separaten Fenstern eine Tageszeit und seinen Namen eingeben.
 * Die Ausgabe enthält die eben eingegebenen Werte in der Form "Guten <TAGESZEIT>, <NAME> !"
 * @author Andreas Suender
 * @version 2019-02-18s
 */
public class GrussMitEingabe {
    public static void main(String[] args) {
        // Tageszeit und Name einfordern...
        String tagesZeit = JOptionPane.showInputDialog(null, "Bitte eine Tageszeit eingeben!");
        String name = JOptionPane.showInputDialog(null, "Bitte Namen eingeben!");

        // ... und hier ausgeben
        JOptionPane.showMessageDialog(null, "Guten "+tagesZeit+",\n"+name+"!");
    }
}