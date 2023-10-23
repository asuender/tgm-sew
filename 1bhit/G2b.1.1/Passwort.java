import javax.swing.JOptionPane;

/**
 * Der Benutzer muss ein Passwort eingeben, um eine Nachricht angezeigt zu bekommen.
 * Ist die Eingabe nach 5 Eingaben immer noch falsch, bricht das Programm ab.
 * Ansonsten bekeommt er die Nachricht zu sehen.
 * @author Andreas Suender
 * @version 2020-03-27
 */
public class Passwort {
    public static void main(String[] args) {
        // Deklarationen
        String passwort = "SEW1BHIT";
        int counter = 0;
        // folgende Variable wird dazu verwendet, um trotzdem nach dem Schleifenabbruch feststellen zu können, ob der Benutzer richtig lag oder nicht
        boolean correct = false;

        do {
            if ((JOptionPane.showInputDialog(null, "Bitte (nochmals) das Passwort eingeben:")).equals(passwort)) {
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
            JOptionPane.showMessageDialog(null, "Passwort korrekt! Die Nachricht: I am from Austria!");
        else {
            JOptionPane.showMessageDialog(null, "Passwort falsch! Sie haben keinen Zugriff zur Nachricht!");
        }
    }
}