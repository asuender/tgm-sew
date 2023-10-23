package asuender.wortexceptions;

public class ValueParseException extends RuntimeException {
    /**
     * Initialisiert eine neue einfache 'ValueParseException'.
     */
    public ValueParseException() {
        super("File or line is empty.");
    }

    /**
     * Initialisiert eine neue 'ValueParseException' mit dem Pfad der betreffenden Datei.
     * @param path Dateipfad
     */
    public ValueParseException(String path) {
        super(String.format("File '%s' is empty.", path));
    }

    /**
     * Initialisiert eine neue 'ValueParseException' mit der Nummer der betreffenden Zeile.
     * @param line Nummer der Zeile
     */
    public ValueParseException(int line) {
        super(String.format("Failed to pass value at line %d.", line));
    }

    /**
     * Initialisiert eine neue 'ValueParseException' mit der Nummer der betreffenden Zeile
     * und dem Pfad der betreffenden Datei.
     * @param path Dateipfad
     * @param line Nummer der Zeile
     */
    public ValueParseException(String path, int line) {
        super(String.format("Line %d is empty in file '%s'", line, path));
    }
}
