package asuender.wortexceptions;

public class FileCorruptException extends Exception {
    public FileCorruptException() {
        super("File corrupt.");
    }

    public FileCorruptException(String path) {
        super(String.format("File '%s' corrupt at.", path));
    }

    public FileCorruptException(int line) {
        super(String.format("File corrupt at line %d.", line));
    }

    public FileCorruptException (String path, int line)  {
        super(String.format("File '%s' corrupt at line %d.", path, line));
    }
}
