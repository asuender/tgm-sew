package asuender;

import asuender.wortexceptions.FileCorruptException;
import asuender.wortexceptions.FileOrLineEmptyException;
import asuender.wortexceptions.ValueParseException;

import java.io.*;

/**
 * Diese Klasse stellt Methoden bereit, um einen als Text gespeicherten Worttrainer
 * (durch die 'WortWriter' Klasse) einlesen zu können.
 * @author Andreas Suender
 * @version 10-06-2021
 */
public class WortReader {
    final static String DEFAULT_PATH = "./WortTrainer.txt";

    private int currentLine = 0;
    private String path;
    final private BufferedReader in;

    /**
     * Initialisiert ein einfaches 'WortReader' Objekt, hierbei wird zum Auslesen der Standardpfad verwendet.
     * @throws FileNotFoundException wird geworfen, wenn die Datei nicht gefunden werden kann.
     */
    public WortReader() throws FileNotFoundException {
        this.path = DEFAULT_PATH;
        this.in = new BufferedReader(new FileReader(path));
    }

    /**
     * Initialisiert ein neues 'WortReader' Objekt mit dem Pfad der Datei, aus welcher gelesen werden soll.
     * @param path Pfad zur Datei
     * @throws FileNotFoundException wird geworfen, wenn die Datei nicht gefunden werden kann.
     */
    public WortReader(String path) throws FileNotFoundException {
        this.path = path;
        this.in = new BufferedReader(new FileReader(path));
    }

    /**
     * Liest die Datei aus und gibt einen Worttrainer zurück.
     * @return wenn erfolgreich, einen Worttrainer
     * @throws IOException wird bei Fehlern beim Einlesen geworfen
     * @throws ValueParseException wird geworfen, wenn Zahlenwerte nicht eingelesen werden können
     */
    public WortTrainer read() throws IOException {
        WortTrainer trainer = new WortTrainer();

        this.checkLine("[WortTrainer]");
        trainer.setListe(this.readWortListe());
        ++this.currentLine;

        try {
            trainer.setSelectedIndex(Integer.parseInt(this.in.readLine()));
            ++this.currentLine;
        } catch(NumberFormatException nfe) {
            this.in.close();
            throw new ValueParseException(this.currentLine);
        }

        trainer.setStatistik(this.readWortStatisktik());

        this.checkEnd();
        ++this.currentLine;

        return trainer;
    }

    /**
     * Liest eine Wortliste aus der Datei ein. Wird nur intern verwendet
     * @return wenn erfolgreich, eine Wortliste
     * @throws IOException wird bei Fehlern beim Einlesen geworfen
     * @throws ValueParseException wird geworfen, wenn Zahlenwerte nicht eingelesen werden können
     */
    private WortListe readWortListe() throws IOException {
        WortListe liste = new WortListe();

        this.checkLine("[WortListe]");

        int eintrageLength;
        try {
            eintrageLength = Integer.parseInt(this.in.readLine());
            ++this.currentLine;
        } catch (NumberFormatException nfe) {
            this.in.close();
            throw new ValueParseException(this.currentLine);
        }

        if (eintrageLength >= 1) {
            for (int i=0; i<eintrageLength; i++) {
                liste.addEntry(readWortEintrag());
            }
        }

        this.checkEnd();
        return liste;
    }

    /**
     * Liest einen einzelnen Worteintrag aus. Wird nur intern verwendet.
     * @return wenn erfolgreich, einen Worteintrag
     * @throws IOException wird bei Fehlern beim Einlesen geworfen
     */
    private WortEintrag readWortEintrag() throws IOException {
        WortEintrag eintrag = new WortEintrag();
        this.checkLine("[WortEintrag]");

        eintrag.setWort(this.in.readLine());
        ++this.currentLine;
        eintrag.setUrl(this.in.readLine());
        ++this.currentLine;

        this.checkEnd();
        return eintrag;
    }

    /**
     * Liest eine Wortstatistik aus. Wird nur eine intern verwendet.
     * @return wenn erfolgreich, eine Wortstatistik
     * @throws IOException wird bei Fehlern beim Einlesen geworfen
     * @throws ValueParseException wird geworfen, wenn Zahlenwerte nicht eingelesen werden können
     */
    private WortStatistik readWortStatisktik() throws IOException {
        WortStatistik statistik = new WortStatistik();
        this.checkLine("[WortStatistik]");

        try {
            statistik.setAbfragenRichtig(Integer.parseInt(this.in.readLine()));
            ++this.currentLine;
            statistik.setAbfragenGesamt(Integer.parseInt(this.in.readLine()));
            ++this.currentLine;
        } catch (NumberFormatException nfe) {
            this.in.close();
            throw new ValueParseException(this.currentLine);
        }

        this.checkEnd();
        return statistik;
    }

    /**
     * Gleicht die aktuelle Zeile mit dem angegebenen String ab.
     * Ist dem nicht so, wird eine Exception geworfen. Wird nur intern verwendet.
     * @param expected String, mit welchem die aktuelle Zeile abgeglichen werden soll
     * @throws IOException wird bei Fehlern beim Einlesen geworfen
     */
    private void checkLine(String expected) throws IOException {
        try {
            String line = this.in.readLine();
            if (line == null) {
                throw new FileOrLineEmptyException(this.path);
            }
            if (!line.trim().equals(expected)) {
                throw new FileCorruptException(this.currentLine);
            }
        } catch(FileCorruptException fce) {
            fce.printStackTrace();
            this.in.close();
            System.exit(1);
        }

        ++this.currentLine;
    }

    /**
     * Prüft, ob die aktuelle Zeile ein Ende ("[end]") markiert. Wenn nicht, dann wird eine Exception geworfen.
     * Wird nur intern verwendet.
     * @throws IOException wird bei Fehlern beim Einlesen geworfen
     */
    private void checkEnd() throws IOException {
        this.checkLine("[end]");
    }
}
