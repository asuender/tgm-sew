import javax.swing.JOptionPane;

/**
 * Der Benutzer muss eine Zahl eingeben. Daraufhin erfolgt eine Ausgabe, in der alle Zahlen zwischen 0
 * und (inklusive) der eingegebenen Zahl einzeln quadriert und deren Ergebnis seperat ausgegeben werden.
 * 
 * @author Andreas Suender
 * @version 2020-02-26
 */

public class Quadratzahlen {
    public static void main(String[] args) {
        // Hier muss die Zahl eingeben werden...
        int number = Integer.parseInt(JOptionPane.showInputDialog(null,"Bitte eine Zahl eingeben."));

        // ... während hier die Ausgabe stattfindet.
        for (int i=0; i<number; i++) {
            System.out.println((i+1) + " * " + (i+1) + " = " + (i+1)*(i+1));
        }
    }
}
