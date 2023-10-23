/**
 * Verschluesselung
 * 
 * Diese Klasse enthält (Objekt-)Methoden zum Ver- und Entschlüsseln von Texten.
 * @author Andreas Suender
 * @version 2020-09-16
 */
public class Verschluesselung {
    private int key;
    
    
    /**
     * Standard-Konstruktor. Initialisiert den Verschiebewert
     * mit 3.
     */
    public Verschluesselung() {
        this(3);    
    }
    
    /**
     * Initialisiert den Verschiebewert mit dem angegebenen Wert
     * des Parameters
     * @param _key gewünschter Verschiebewert
     */
    public Verschluesselung(int _key) {
        if (_key >= 1 && _key <= 25)
            this.key = _key;
    }
    
    /**
     * Initialisiert den Verschiebewert mit der Differenz aus den beiden
     * Stellenwerten des Buchstabens 'A' und dem gewünschten Zeichen in der ASCII-Tabelle.
     * @param _key gewünschtes Zeichen, dessen Differenz zu 'A' gebildet werden soll
     */
    public Verschluesselung(char _symbol) {
        _symbol = Character.toUpperCase(_symbol);
        this.key = (int)(_symbol-'A');
    }
    
    /**
     * Setzt den Verschiebewert auf den angegebenen Wert
     * des Parameters
     * @param _key gewünschter Verschiebewert
     */
    public void setKey(int _key) {
        if (_key >= 1 && _key <= 25)
            this.key = _key;
    }
    
    /**
     * Setzt den Verschiebewert auf die Differenz aus den beiden
     * Stellenwerten des Buchstabens 'A' und dem gewünschten Zeichen in der ASCII-Tabelle.
     * @param _key gewünschtes Zeichen, dessen Differenz zu 'A' gebildet werden soll
     */
    public void setKey(char _symbol) {
        _symbol = Character.toUpperCase(_symbol);
        this.setKey((int)(_symbol-'A'));
    }
    
    /**
     * Gibt den Verschiebewert des aktuellen Objekts zurück.
     * @return Verschiebewert
     */
    public int getKey() {
        return this.key;
    }

    /**
     * Entschlüsselt einen Text entsprechend des im Objekt hinterlegten
     * Verschiebewertes
     * @param input Text, der verschlüsselt werden soll
     * @param shift Verschiebung
     * @return verschlüsselter Text
     */
    public String verschluesseln(String input) {
        char c, replacedChar;
        String decr = "";
        input = input.toUpperCase();
        for (int i = 0; i < input.length(); i++) {
            c = input.charAt(i);
            replacedChar = (char)(c + this.key);
            if (replacedChar > 90)
                replacedChar -= 26;
            decr += replacedChar;
        }
        return decr.toUpperCase();
    }


    /**
     * Entschlüsselt einen Text entsprechend des im Objekt hinterlegten
     * Verschiebewertes
     * @param input Text, der entschlüsselt werden soll
     * @param shift Verschiebung
     * @return entschlüsselter Text
     */
    public String entschluesseln(String input) {
        String encr = "";
        char c, replacedChar;
        input = input.toUpperCase();
        for (int i = 0; i < input.length(); i++) {
            c = input.charAt(i);
            replacedChar = (char)(c - this.key);
            if (replacedChar < 65)
                replacedChar += 26;
            encr += replacedChar;
        }
        return encr.toLowerCase();
    }
}
