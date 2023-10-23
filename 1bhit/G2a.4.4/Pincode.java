import javax.swing.JOptionPane;

/**
 * Der Benutzer muss einen Pincode eingeben, um eine Nachricht angezeigt zu bekommen.
 * Ist die Eingabe nach 5 Eingaben immer noch falsch, bricht das Programm ab.
 * Ansonsten bekeommt er die Nachricht zu sehen.
 * @author Andreas Suender
 * @version 2020-03-16
 */
public class Pincode {
    public static void main(String[] args) {
        // Deklarationen
        int pincode = 917253;
        int counter = 0;
        // folgende Variable wird dazu verwendet, um trotzdem nach dem Schleifenabbruch feststellen zu können, ob der Benutzer richtig lag oder nicht
        boolean correct = false;

        do {
            if (Integer.parseInt(JOptionPane.showInputDialog(null, "Bitte (nochmals) PIN eingeben:")) == pincode) {
                // Hier muss auch 'correct' auf 'true' gesetzt werden, damit der PIN nacher angezeigt wird.
                counter = 5; correct = true;
            }
            else {
                counter++;
            }
        }
        while(counter < 5);

        // Ausgabe
        if (correct == true)
            JOptionPane.showMessageDialog(null, "PIN korrekt! Die Nachricht: I am from Austria!");
        else {
            JOptionPane.showMessageDialog(null, "PIN falsch! Sie haben keinen Zugriff zur Nachricht!");
        }
    }
}