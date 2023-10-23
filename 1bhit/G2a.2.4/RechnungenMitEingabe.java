import javax.swing.JOptionPane;

/**
 * Der Benutzer soll zwei Zahlen in speraten Fenstern eingeben, diese werden dann addiert, subtrahiert,
 * multipliziert, dividiert und der Rest berechnet. Alle Ergebnisse werden schön formatiert in einem weiteren Fenster ausgegeben.
 * @author Andreas Suender
 * @version 2019-02-24
 */

public class RechnungenMitEingabe {
    public static void main(String[] args) {
        // Platzsparender arbeiten .... ;-)
        int num1 = Integer.parseInt(JOptionPane.showInputDialog(null, "Bitte eine Zahl eingeben."));
        int num2 = Integer.parseInt(JOptionPane.showInputDialog(null, "Bitte eine zweite Zahl eingeben."));

        // mehrzeiliger Funktionsaufruf. Hilft, um Platz zu sparen. Die Ergebnisse werden hier direkt berechnet.
        JOptionPane.showMessageDialog(null,
                "Summe: "+num1+" + "+num2+" = "+(num1+num2)+"\n"+
                "Differenz: "+num1+" - "+num2+" = "+(num1-num2)+"\n"+
                "Produkt: "+num1+" * "+num2+" = "+(num1*num2)+"\n"+
                "Quotient: "+num1+" / "+num2+" = "+(num1/num2)+"\n"+
                "Rest der Division: "+num1+" % "+num2+" = "+(num1%num2)+"\n");
    }
}