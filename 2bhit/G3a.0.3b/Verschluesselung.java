/**
 * Verschluesselung
 * 
 * Diese Klasse enthält Methoden zum Ver- und Entschlüsseln von Texten.
 * @author Andreas Suender
 * @version 2020-09-16
 */
public class Verschluesselung {
    /**
     * Verschlüsselt den Parameter input nach der Caesar-Verschlüsselung.
     * @param input Text, der verschlüsselt werden soll
     * @return verschlüsselter Text
     */
    public static String verschluesseln(String input) {
        return verschluesseln(input, 3);
    }

    /**
     * Verschlüsselt den Parameter input wie bei der Caesar-Codierung, die Verschiebung
     * der Buchstaben (als Zahl) kann hier aber mitgegeben werden.
     * @param input Text, der verschlüsselt werden soll
     * @param shift Verschiebung
     * @return verschlüsselter Text
     */
    public static String verschluesseln(String input, int shift) {
        char c, replacedChar;
        String decr = "";
        input = input.toUpperCase();
        for (int i = 0; i < input.length(); i++) {
            c = input.charAt(i);
            replacedChar = (char)(c + shift);
            if (replacedChar > 90)
                replacedChar -= 26;
            decr += replacedChar;
        }
        return decr.toUpperCase();
    }

    /**
     * Verschlüsselt den Parameter input ähnlich der Caesar-Codierung, displace gibt an, 
     * zu welchem Buchstaben das 'A' verschoben werden soll.
     * @param input Text, der verschlüsselt werden soll
     * @param displace Verschiebung relativ zum 'A'
     * @return verschlüsselter Text
     */
    public static String verschluesseln(String input, char displace) {
        displace = Character.toUpperCase(displace);
        return verschluesseln(input, (int) displace - 'A');
    }

    /**
     * Entschlüsselt input nach der Caesar-Codierung.
     * @param input Text, der entschlüsselt werden soll
     * @return entschlüsselter Text
     */
    public static String entschluesseln(String input) {
        return entschluesseln(input, 3);
    }

    /**
     * Entschlüsselt input ähnlich der Caeser-Codierung, der Verschiebung der Buchstaben (als Zahl)
     * kann hier mitangegeben werden.
     * @param input Text, der entschlüsselt werden soll
     * @param shift Verschiebung
     * @return entschlüsselter Text
     */
    public static String entschluesseln(String input, int shift) {
        String encr = "";
        char c, replacedChar;
        input = input.toUpperCase();
        for (int i = 0; i < input.length(); i++) {
            c = input.charAt(i);
            replacedChar = (char)(c - shift);
            if (replacedChar < 65)
                replacedChar += 26;
            encr += replacedChar;
        }
        return encr.toLowerCase();
    }

    /**
     * Entschlüsselt input ähnlich der Caesar-Codierung, displace gibt an, zu welchem Buchstaben das 'A'
     * verschoben werden soll.
     * @param input Text, der entschlüsselt werden soll
     * @param displace Verschiebung relativ zum 'A'
     * @return entschlüsselter Text
     */
    public static String entschluesseln(String input, char displace) {
        displace = Character.toUpperCase(displace);
        return entschluesseln(input, (int)(displace - 'A'));
    }
}
