package asuender.wortexceptions;

/**
 * Diese Klasse stellt eine Excpetion bereit, welche verwendet werden kann,
 * wenn eine Datei oder eine Zeile in dieser leer ist.
 * Dabei kann als Argument der Dateiname und die entsprechende Zeile mitgegeben werden.
 * @author Andreas Suender
 * @version 10-06-2021
 */
public class FileOrLineEmptyException extends RuntimeException {
    /**
     * Initialisiert eine neue einfache 'FileOrLineEmptyException'.
     */
    public FileOrLineEmptyException() {
        super("File or line is empty.");
    }

    /**
     * Initialisiert eine neue 'FileOrLineEmptyException' mit dem Pfad der betreffenden Datei.
     * @param path Dateipfad
     */
    public FileOrLineEmptyException(String path) {
        super(String.format("File '%s' is empty.", path));
    }

    /**
     * Initialisiert eine neue 'FileOrLineEmptyException' mit der Nummer der betreffenden Zeile.
     * @param line Nummer der Zeile
     */
    public FileOrLineEmptyException(int line) {
        super(String.format("Line %d is empty.", line));
    }

    /**
     * Initialisiert eine neue 'FileOrLineEmptyException' mit der Nummer der betreffenden Zeile
     * und dem Pfad der betreffenden Datei.
     * @param path Dateipfad
     * @param line Nummer der Zeile
     */
    public FileOrLineEmptyException(String path, int line) {
        super(String.format("Line %d is empty in file '%s'", line, path));
    }
}
