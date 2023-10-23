import javax.swing.JOptionPane;

/**
 * Dieses Programm fragt den Benutzer nach einer ganzen Zahl, so oft bis er nicht mehr will.
 * Am Ende wird die Anzahl der eingelesenen Zahlen und der Mittelwert aller Zahlen ausgegeben.
 * @author Andreas Suender
 * @version 2020-03-16
 */
public class Zahlenstatistik {
    /**
     * Dieses Programm fragt den Benutzer nach einer ganzen Zahl, so oft bis er nicht mehr will.
     * Am Ende wird die Anzahl der eingelesenen Zahlen und der Mittelwert aller Zahlen ausgegeben.
     * @param args not used
     */
    public static void main(String[] args) {
        // Deklarationen/Initialisierungen
        int counter = 0;
        double number;
        boolean answer = true;
        double sum = 0;

        do {
            number = Integer.parseInt(JOptionPane.showInputDialog(null, "Bitte eine Zahl eingeben."));
            answer = Boolean.parseBoolean(JOptionPane.showInputDialog(null, "Eine weitere Zahl eingeben? (true/false)"));
            // verkürzter Programmcode ist immmer gut.
            // Der Mittelwert wird schon vorher berechnet.
            counter++;
            sum+=number;
        }
        while(answer == true);
        // Ausgabe
        JOptionPane.showMessageDialog(null, counter+" Zahl(en) wurde eingegeben; Mittelwert: "+(sum/counter)+"\nSumme: "+sum);
    }
}
