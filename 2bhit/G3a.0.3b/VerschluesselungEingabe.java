/**
 * Diese Klasse verdeutlicht die Verwendung aller Methoden aus der Klasse
 * 'Verschluesselung'.
 * @author Andreas Suender
 * @vesion 2020-09-18
 */
public class VerschluesselungEingabe {
    public static void main(String[] args) {
        /*
         * Die nächsten Variablen müssen hier deklariert werden,
         * weil sich sonst der Compiler beschwert.
         */
        int shift;
        char displace;
        String output = "Das Ergebnis: ";
        
        System.out.println("Was möchten Sie tun?\n"+
        "1) Einen Text mittels Standard-Cäsar-Verschlüsselung verschlüsseln.\n"+
        "2) Einen Text durch Eingabe eines eigenen Verschiebewertes verschlüsseln.\n"+
        "3) Einen Text durch Eingabe eines eigenen Schlüsselbuchstabens verschlüsseln.\n"+
        "4) Einen Text mittels Standard-Cäsar-Verschlüsselung entschlüsseln.\n"+
        "5) Einen Text durch Eingabe eines eigenen Verschiebewertes entschlüsseln.\n"+
        "6) Einen Text durch Eingabe eines eigenen Schlüsselbuchstabens entschlüsseln.\n"
        );
        
        String choice = Input.readLine("Ihre Wahl:", 1);
        int choiceNum = Integer.parseInt(choice);
        
        String input = Input.readLine("Der zu ver- bzw. entschlüsselnde Text:", 1);
        
        switch (choiceNum) {
            case 1:
                output += Verschluesselung.verschluesseln(input);
                break;
            case 2:
                shift = Integer.parseInt(Input.readLine("Der Verschiebewert:", 1));
                output += Verschluesselung.verschluesseln(input, shift);
                break;
            case 3:
                displace = Input.readLine("Der Schlüsselbuchstabe:", 1).charAt(0);
                output += Verschluesselung.verschluesseln(input, displace);
                break;
            case 4:
                output += Verschluesselung.entschluesseln(input);
                break;
            case 5:
                shift = Integer.parseInt(Input.readLine("Der Verschiebewert:", 1));
                output += Verschluesselung.entschluesseln(input, shift);
                break;
            case 6:
                displace = Input.readLine("Der Schlüsselbuchstabe:", 1).charAt(0);
                output += Verschluesselung.entschluesseln(input, displace);
                break;
            default:
                // einfaches Verlassen bei ungültiger Eingabe
                System.exit(0);
        }
        System.out.println(output);
    }
}
