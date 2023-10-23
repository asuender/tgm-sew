import javax.swing.JOptionPane;

/**
 * Der Benutzer soll für die Berechnung einer Raute beliebige Werte für die Diagonalen e und f eingeben,
 * damit das Programm daraufhin drei Werte (Umfang, Seite, Fläche) für ihn berechnet und ausgibt.
 * Sind diese Werte jedoch nicht sinnvoll, so wird ein Fehler angezeigt und der Benutzer bekommt noch eine Chance.
 * @author Andreas Suender
 * @version 2020-03-16
 */
public class RautenBerechnung {
    public static void main(String[] args) {
        boolean sense = true;
        double e;
        double f;

        do {
            /*
             Die unteren zwei Zeilen mögen etwas kompliziert aussehen, aber es hat einen ganz speziellen Grund:
             Würde man einfach 'Double.parseDouble' schreiben, dann werden auch normale ganze Zalen wie 5 als Fehler angezeigt.
             Somit ist es hier so umgesetzt worden, dass man sehr wohl auch ganze Zahlen eingeben kann, damit diese dann zwischenzeitlich
             in einem 'int' gespeichert und dann in ein double per type cast konvertiert werden können (zur korrekten Verwendung).
             */
            e = (double)Integer.parseInt(JOptionPane.showInputDialog(null, "Bitte den Wert für die Diagonale e eingeben"));
            f = (double)Integer.parseInt(JOptionPane.showInputDialog(null, "Bitte den Wert für die Diagonale f eingeben."));

            // mit 'sense' ist hier 'Sinn' gemeint (false= kein Sinn; true=Sinn)
            if (e <= 0 || f <= 0) sense = false;
            if (sense == true) {
                JOptionPane.showMessageDialog(null, "Seite a der Raute: "+RautenFormeln.seite(e,f)+"\n"
                                    +"Umfang U der Raute: "+RautenFormeln.umfang(e, f)+"\n"
                                    +"Flächeninhalt A der Raute: "+RautenFormeln.flaeche(e, f));
            }
            // erscheint wenn die Zahl negativ bzw. 0 ist, nochmal versuchen
            else {
                JOptionPane.showMessageDialog(null, "Fehler! Bitte erneut eingeben.");
            }
        }
        while(sense == false);
    }
}