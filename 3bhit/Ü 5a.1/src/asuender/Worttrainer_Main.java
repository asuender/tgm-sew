package asuender;

/**
 * Diese Klasse testet die anderen "Wort-"-Klassen auf Herz und Nieren.
 * Manche Aufrufe sollen absichtlich Exceptions erzwingen, um die Funktionaliät der Klassen zu überprüfen.
 * @author Andreas Suender
 * @version 09-19-2021
 */
public class Worttrainer_Main {
    public static void main(String[] args) {
        /* Testen der Klasse 'asuender.WortEintrag' */
        WortEintrag wortEintrag = new WortEintrag("Gummibär", "https://orf.at");

        // Diese beiden Aufrufe enden in einer Exception
        //wortEintrag.setWort("");
        //wortEintrag.setUrl(null);

        System.out.println(WortEintrag.checkURL("https://orf.at"));
        System.out.println(wortEintrag); // toString() wird hier autom. aufgerufen

        /* Testen der Klasse 'asuender.WortListe' */
        //asuender.WortListe wortListe = new asuender.WortListe(null); // wirft eine Exception
        WortListe wortListe = new WortListe(new WortEintrag[]{});

        System.out.println(wortListe.getLength());
        wortListe.addEntry(new WortEintrag("ABC", "https://example.com"));
        System.out.println(wortListe.getLength());

        // die unteren beiden Aufrufe enden in einer Exception
        //System.out.println(wortListe.eintragAt(-1));
        //System.out.println(wortListe.eintragAt(2));
        System.out.println(wortListe.eintragAt(0)); // ruft wieder .toString() auf
        System.out.println(wortListe.deleteEintrag("XYZ"));
        System.out.println(wortListe); // ruft wieder .toString() auf

        wortListe.addEntry(new WortEintrag("ABC", "https://example.com"));

        /* Testen der Klasse 'asuender.WortTrainer' */
        WortTrainer trainer = new WortTrainer(wortListe);
        trainer.randomEntry();
        System.out.println(trainer.getSelected());

        // 'check'-Methoden
        //trainer.check(""); // endet in einer Exception
        System.out.println(trainer.check("XYZ"));
        System.out.println(trainer.checkIgnoreCase("abc"));
    }
}