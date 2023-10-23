package asuender;

import java.io.IOException;

/**
 * Diese Klasse testet die anderen "Wort-"-Klassen auf Herz und Nieren.
 * Manche Aufrufe sollen absichtlich Exceptions erzwingen, um die Funktionaliät der Klassen zu überprüfen.
 * @author Andreas Suender
 * @version 10-06-2021
 */
public class Worttrainer_Main {
    public static void main(String[] args) throws IOException {
        /* Testen der Klasse 'asuender.WortEintrag' */
        WortEintrag eintrag = new WortEintrag("Gummibär", "https://orf.at"); // URL sollte eigentlich zu einem Bild führen ....

        // Diese beiden Aufrufe enden in einer Exception
        //wortEintrag.setWort("");
        //wortEintrag.setUrl(null);

        System.out.println(WortEintrag.checkURL("https://orf.at"));
        System.out.println(eintrag); // toString() wird hier autom. aufgerufen

        /* Testen der Klasse 'asuender.WortListe' */
        //asuender.WortListe wortListe = new asuender.WortListe(null); // wirft eine Exception
        WortListe liste = new WortListe();

        System.out.println(liste.getEintraege().size());
        liste.addEntry(new WortEintrag("ABC", "https://example.com"));
        System.out.println(liste.getEintraege().size());

        // die unteren beiden Aufrufe enden in einer Exception
        //System.out.println(wortListe.eintragAt(-1));
        //System.out.println(wortListe.eintragAt(2));
        System.out.println(liste.eintragAt(0)); // ruft wieder .toString() auf
        System.out.println(liste.deleteEintrag("XYZ"));
        System.out.println(liste); // ruft wieder .toString() auf

        liste.addEntry(new WortEintrag("Hund", "https://example.com"));

        System.out.println(liste);

        /* Testen der Klasse 'asuender.WortTrainer' */
        WortTrainer trainer = new WortTrainer(liste);
        trainer.randomEntry();
        System.out.println(trainer.getSelected());

        // 'check'-Methoden
        //trainer.check(""); // endet in einer Exception
        System.out.println(trainer.check("Hund"));
        System.out.println(trainer.checkIgnoreCase("hund"));

        // Statistik
        System.out.printf("%.1f %%%n", trainer.zeigeErgebnis()); // wie String.format()

        /* WortTrainer in Datei schreiben und aus Datei lesen: */
        // Einträge hinzufügen, damit wir etwas zum Speichern haben
        liste.addEntry(new WortEintrag("ABC", "https://example.com"));
        liste.addEntry(new WortEintrag("ABC", "https://example.com"));
        liste.addEntry(new WortEintrag("ABC", "https://example.com"));
        liste.addEntry(new WortEintrag("ABC", "https://example.com"));
        liste.addEntry(new WortEintrag("ABC", "https://example.com"));
        trainer.setStatistik(new WortStatistik(5, 10));

        String path = "./trainer.txt";
        WortWriter writer = new WortWriter(path);
        writer.write(trainer, path);
        System.out.println("----------------------\n\u001b[1mWrote 'WortTrainer' to " + path + ".\u001b[0m");

        // WortTrainer aus Datei lesen
        WortReader reader = new WortReader(path);
        WortTrainer trainerGelesen = reader.read();
        System.out.println(
                "\u001b[4mRead 'WortTrainer' from " + path +
                ":\u001b[0m\n" +
                trainerGelesen.getListe().toString() + "\n" +
                trainerGelesen.getStatistik()
        );
    }
}