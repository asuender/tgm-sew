import javax.swing.JOptionPane;

/**
 * Diese Klasse enthält ein Ratespiel, bei dem der Benutzer eine Zufallszahl erraten muss.
 * @author Andreas Suender
 * @version 2020-03-11
 */
public class Ratespiel {
    /**
     * Der Computer 'sucht' sich eine Zahl zwischen 1 und 10 aus, der Benutzer muss sie erraten.
     * Liegt er falsch, so werden ihm Meldungen angezeigt, dass seine eingegebene Zahl zu groß oder zu klein ist.
     * Wurde die Zahl am Ende erraten, werden dem Benutzer auch die Anzahl der Versuche angezeigt.
     * @param args Not used
     */
    public static void main(String[] args) {
        // Deklarationen aller Variablen, bis auf die letzte alle auch initialisiert
        int randomNum = Zufall.zufall1Bis10(); // Aufruf der Nachbarmethode 
        int counter = 1;
        boolean zahlErraten = false;
        int inputNum;
       
        do {
            // Direkte Konvertierung in Int
            inputNum = Integer.parseInt(JOptionPane.showInputDialog(null, "Versuche, meine Zahl zu erraten:"));

            // Ausgabemeldungen
            if (inputNum > randomNum) {
                JOptionPane.showMessageDialog(null, "Die Zahl ["+inputNum+"] zu groß!");
                counter += 1;
            }
            else if (inputNum < randomNum) {
                JOptionPane.showMessageDialog(null, "Die Zahl ["+inputNum+"] zu klein!");
                counter +=1;
            }
            else {
                zahlErraten = true;
            }
        }
        while (zahlErraten == false);

        // Ausgabe der Zahl und der Versuche
        JOptionPane.showMessageDialog(null, "Die Zahl ["+inputNum+"] ist richtig und wurde nach "+counter+" Versuch(en) erraten!");
    }
}