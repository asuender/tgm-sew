import javax.swing.JOptionPane;

/**
 * Der Benutzer muss irgendein beliebiges Zeichen eingeben, wie z.B. "#" und eine Zahl.
 * Daraufhin werden so viele Zeilen ausgegeben wie vorher eingegeben wurde, wobei diese mit dem eingegebenen
 * Zeichen gefüllt werden (beginnend bei 1 Zeichen); mit jeder Zeile wird ein Zeichen mehr ausgegeben,
 * bis die endgültige Anzahl der Zeilen erreicht ist.
 * @author Andreas Suender
 * @version 2019-02-26
 */

public class WeitereMuster {
    public static void main(String[] args) {
        // Einfache Eingabe der benötigten Daten
        String symbol = JOptionPane.showInputDialog(null, "Bitte gewünschtes Zeichen eingeben.");
        int RowCount = Integer.parseInt(JOptionPane.showInputDialog(null, "Bitte Zeilenlänge eingeben"));

        // Ausgabe
        for (int i=0; i<RowCount; i++) {
            for (int j=0; j<i; j++) System.out.print(symbol);
            System.out.println(symbol);
        }
    }
}