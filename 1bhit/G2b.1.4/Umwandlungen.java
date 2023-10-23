import javax.swing.JOptionPane;

/**
 * Umwandlungen
 * Der Benutzer kann mit diesem Programm einen Unicode-Wert in ein Zeichen und umgekehrt konvertieren lassen.
 * Anfangs kann er zwischen diesen beiden Richtungen entscheiden und muss dementsprechend ein Zeichen bzw. Unicode-Wert eingeben.
 * Die Ausgabe erfolgt direkt danach mit eingegebenem Wert/Zeichen + Eregbnis.
 * Dies läuft so lange in einer Schleife, bis sie am Ende jeder Umwandlung per Texteingabe beendet wird.
 */
public class Umwandlungen {

    public static void main(String[] args) {
        // Deklarationen
        String userInput;
        String userInputValue;
        String message = "";
        boolean question;

        // Hauptschleife
        do {
            // Eingabe Umwandlungsart + Zeichen/Wert
            userInput = JOptionPane.showInputDialog(null, "Umwandeln:\nUnicode => Zeichen (C, c)\nZeichen => Unicode (U, u)");
            userInputValue = JOptionPane.showInputDialog(null, "Bitte ein Zeichen/Unicode-Wert eingeben:");
            // Umwandeln je nach Eingabe
            if (userInput.charAt(0) == 'C' || userInput.charAt(0) == 'c') 
                message = "Umwandeln in ein Zeichen:\nEingabe Unicode-Wert: "+userInputValue+"\nAusgabe Zeichen: "+(char)Integer.parseInt(userInputValue);
            else if (userInput.charAt(0) == 'U' || userInput.charAt(0) == 'u')
                message = "Umwandeln in einen Unicode-Wert:\nEingabe Zeichen: "+userInputValue+"\nAusgabe Unicode-Wert: "+(int)userInputValue.charAt(0);

            // Ausgabe + Frage
            JOptionPane.showMessageDialog(null, message);
            question = Boolean.parseBoolean(JOptionPane.showInputDialog(null, "Noch eine Umwandlung durchführen? (true/false)"));
        }
        while(question == true);
    }
}