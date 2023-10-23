package asuender;

import java.io.*;

/**
 * Diese Klasse dient dem Speichern von Worttrainern.
 * @author Andreas Suender
 * @version 10-06-2021
 */
public class WortWriter {
    final static String DEFAULT_PATH = "./WortTrainer.txt";

    private String path;
    private PrintWriter out;

    /**
     * Erstellt einen neuen Worttrainer mit dem Pfad der Datei, in welche geschrieben werden soll.
     * Darf kein Nullobjekt sein.
     * @param path Pfad der Datei
     * @throws FileNotFoundException wird geworfen, wenn die Datei nicht gefunden werden kann.
     */
    public WortWriter(String path) throws FileNotFoundException {
        if (path.trim().isEmpty() || path == null) {
            throw new IllegalArgumentException("Der Pfad darf nicht leer oder ein Nullobjekt sein!");
        }
        this.path = path;

        this.out = new PrintWriter(new FileOutputStream(path), true);
    }

    /**
     * Setzt den Pfad der Datei, in welche geschrieben werden soll. Darf kein Nullobjekt sein.
     * @param path Pfad der Datei
     * @throws FileNotFoundException wird geworfen, wenn die Datei nicht gefunden werden kann.
     */
    public void setPath(String path) throws FileNotFoundException {
        if (path.trim().isEmpty() || path == null) {
            throw new IllegalArgumentException("Der Pfad darf nicht leer oder ein Nullobjekt sein!");
        }
        this.path = path;

        this.out = new PrintWriter(new FileOutputStream(path), true);
    }

    /**
     * Schreibt den mitgegebenen Worttrainer in die angegebene Datei.
     * @param wortTrainer Worttrainer
     * @param path Pfad der Datei
     */
    public void write(WortTrainer wortTrainer, String path) {
        this.path = path;
        this.saveWortTrainer(wortTrainer);
    }

    /**
     * Schreibt den mitgegebenen Worttrainer in die Standard-Datei.
     * @param wortTrainer Worttrainer
     */
    public void write(WortTrainer wortTrainer) {
        this.write(wortTrainer, DEFAULT_PATH);
    }

    /**
     * Speichert einen einzelnen Worttrainer in die Datei. Wird nur intern verwendet.
     * @param trainer Worttrainer
     */
    private void saveWortTrainer(WortTrainer trainer) {
        this.out.println("[WortTrainer]");

        saveWortListe(trainer.getListe());
        this.out.println(trainer.getSelectedIndex());

        this.saveWortStatisktik(trainer.getStatistik());

        this.out.println("[end]");
        this.out.close();
    }

    /**
     * Speichert eine einzelne Wortliste in die Datei. Wird nur intern verwendet.
     * @param liste Wortliste
     */
    private void saveWortListe(WortListe liste) {
        WortEintrag[] eintraege = liste.getEintraege();

        this.out.println("[WortListe]" + System.lineSeparator() + eintraege.length);

        for (WortEintrag eintrag : liste.getEintraege()) {
            saveWortEintrag(eintrag);
        }

        this.out.println("[end]");
    }

    /**
     * Speichert einen einzelnen Worteintrag in die Datei. Wird nur intern verwendet.
     * @param eintrag Worteintrag
     */
    private void saveWortEintrag(WortEintrag eintrag) {
        this.out.println("[WortEintrag]");
        this.out.println(eintrag.getWort() + System.lineSeparator() + eintrag.getUrl());
        this.out.println("[end]");
    }

    /**
     * Speichert eine einzelne Wortstatistik in die Datei. Wird nur intern verwendet.
     * @param statistik Wortstatistik
     */
    private void saveWortStatisktik(WortStatistik statistik) {
        this.out.println(String.format(
                "[WortStatistik]\n%d\n%d\n[end]",
                statistik.getAbfragenRichtig(),
                statistik.getAbfragenGesamt()));
    }
}
