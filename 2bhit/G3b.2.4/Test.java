import java.util.Scanner;

/**
 * Die Klasse testet und veranschaulicht die Nutzung der Klassen 'Musikstueck' und 'MusikAlbum'.
 * @author Andreas Suender
 * @version 11-23-2020
 */
public class Test {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        System.out.println("Bitte den Titel für das erste Musikstück eingeben: ");
        String m_titel = console.nextLine();
        System.out.println("Bitte den Interpreten für das erste Musikstück eingeben: ");
        String m_interpret = console.nextLine();
        System.out.println("Bitte die Dauer für das erste Musikstück eingeben: ");
        int m_dauer = console.nextInt();

        Musikstueck m = new Musikstueck(m_titel, m_interpret, m_dauer);

        System.out.println("\nKontrolle: \n"+m.zeigeDaten());
        
        System.out.println("=======================");
        
        System.out.println("Erstellen wir ein neues Musikalbum. Wie soll es heißen?"); // diese zwei Zeilen werden komischerweise
        String ma_name = console.nextLine();                                           // übersprungen bei mir
        System.out.println("Bitte geben Sie den Interpreten für das Musikalbum ein: ");
        String ma_interpret = console.nextLine();
        System.out.println("Wie viele Musikstuecke soll es beinhalten? :");
        byte ma_anzahl = console.nextByte();
        MusikAlbum ma = new MusikAlbum(ma_name, ma_interpret, ma_anzahl);

        System.out.println("Soll das vorher erzeugte Musikstück hinzugefügt werden? (true/false) :");
        if (console.nextBoolean())
            ma.addMusikstueck(m);
        else {
            System.out.println("Stattdessen ein eigenes Stück hinzufügen? (true/false) :");
            if (console.nextBoolean()) {
                System.out.println("Wie viele Stücke sollen hinzugefügt werden? :");
                int maAdd_anzahl = console.nextInt();

                for (int i=0; i<maAdd_anzahl; i++) {
                    System.out.println("Bitte den Titel für das "+i+".Musikstück eingeben: ");
                    String mTemp_titel = console.nextLine();
                    System.out.println("Bitte den Interpreten für das "+i+".Musikstück eingeben: ");
                    String mTemp_interpret = console.nextLine();
                    System.out.println("Bitte die Dauer für das "+i+".Musikstück eingeben: ");
                    byte mTemp_dauer = console.nextByte();

                    ma.addMusikstueck(new Musikstueck(mTemp_titel, mTemp_interpret, mTemp_dauer));
                }
                 
            }  
        }
        
        System.out.println("\nKontrolle:\n"+ma.listMusikstuecke());

        System.out.println("Ein Musikstück löschen? (true/false) :");
        if (console.nextBoolean()) {
            System.out.println("Bitte den Nummerntitel eingeben: ");
            int maRemove_numer = console.nextInt();
            ma.removeMusikstueck(maRemove_numer);   
        }

        System.out.println("\nKontrolle:\n"+ma.listMusikstuecke());
    }
}
