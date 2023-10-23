import java.util.stream.IntStream;

/**
 * Verschluesselung
 * 
 * Diese Klasse enthält Methoden zum Ver- und Entschlüsseln von Texten.
 * @author Andreas Suender
 * @version 2020-05-12
 */
public class Verschluesselung {

    /* Generiert die ASCII-Tabelle */
    static String s = new String(IntStream.rangeClosed(32, 126).toArray(), 0, 95);
    static char[] ascii_table = s.toCharArray();
    static int ascii_length = ascii_table.length; // sollte 95 sein

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
        String decr = input;
        char c;
        int index;
        for (int i=0; i<decr.length(); i++) {
            c=decr.charAt(i);
            index = new String(ascii_table).indexOf(c);
            decr = decr.substring(0, i)+ascii_table[(index+shift >= ascii_length)? index+shift-ascii_length : index+shift]+decr.substring(i+1);
        }
        return decr;
    }

    /**
     * Verschlüsselt den Parameter input ähnlich der Caesar-Codierung, displace gibt an, 
     * zu welchem Buchstaben das 'A' verschoben werden soll.
     * @param input Text, der verschlüsselt werden soll
     * @param displace Verschiebung relativ zum 'A'
     * @return verschlüsselter Text
     */
    public static String verschluesseln(String input, char displace) {
        return verschluesseln(input, (int)displace-'A'); 
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
        String encr = input;
        char c;
        int index;
        for (int i=0; i<encr.length(); i++) {
            c=encr.charAt(i);
            index = new String(ascii_table).indexOf(c);
            encr = encr.substring(0, i)+ascii_table[(index-shift<0)? index+ascii_length-shift : index-shift]+encr.substring(i+1);
        }
        return encr;
    }

    /**
     * Entschlüsselt input ähnlich der Caesar-Codierung, displace gibt an, zu welchem Buchstaben das 'A'
     * verschoben werden soll.
     * @param input Text, der entschlüsselt werden soll
     * @param displace Verschiebung relativ zum 'A'
     * @return entschlüsselter Text
     */
    public static String entschluesseln(String input, char displace) {
        return entschluesseln(input,(int)displace-'A');
    }
}
