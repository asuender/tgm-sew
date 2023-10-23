import javax.swing.JOptionPane;

/**
 * Eingabe
 * 
 * Der Benutzer wird aufgefordert, eine Dezimalzahl einzugeben, die dann als Radius verwendet wird, um alle Methoden
 * aus `Kugelberechnungen` zu testen.
 * @author Andreas Suender
 * @version 2020-06-16
 */
public class Eingabe {
    
    public static void main(String[] args) {
        double radius = Double.parseDouble(JOptionPane.showInputDialog(null, "Bitte eine Dezimalzahl eingeben:"));
        JOptionPane.showMessageDialog(null, "Durchmesser der Kugel: "+Kugelberechnungen.durchmesser(radius)+"\n" +
        "Oberfläche der Kugel: "+Kugelberechnungen.oberflaeche(radius)+"\n" +
        "Volumen der Kugel: "+Kugelberechnungen.volumen(radius)
        );
    }
}