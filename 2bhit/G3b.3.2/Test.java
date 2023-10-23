import java.util.Scanner;

/**
 * Die Klasse testet und die beiden Klassen 'Musikstueck' und 'MusikAlbum' und zeigt damit auch,
 * dass die clone()-Methoden richtig funktionieren.
 * @author Andreas Suender
 * @version 11-12-2020
 */
public class Test {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        System.out.println("Bitte den Titel für das erste Musikstück eingeben: ");
        String m_titel = console.nextLine();
        System.out.println("Bitte den Interpreten für das erste Musikstück eingeben: ");
        String m_interpret = console.nextLine();
        System.out.println("Bitte die Dauer für das erste Musikstück eingeben: ");
        int m_dauer = Integer.parseInt(console.nextLine());

        Musikstueck m = new Musikstueck(m_titel, m_interpret, m_dauer);

        System.out.println("\nKontrolle: \n"+m.zeigeDaten());
        
        System.out.println("=======================");
        
        System.out.println("Erstellen wir ein neues Musikalbum. Wie soll es heißen?");
        String ma_name = console.nextLine(); 
        System.out.println("Bitte geben Sie den Interpreten für das Musikalbum ein: ");
        String ma_interpret = console.nextLine();
        MusikAlbum ma = new MusikAlbum(ma_name, ma_interpret);

        ma.addMusikstueck(m);

        System.out.println("Kontrolle des Musikalbums:\n"+ma.listMusikstuecke());

        System.out.println("Soll das bestehende Musikstück aus dem Album entfernt werden? (nein=0, ja=1): ");
        int choice_remove = console.nextInt();
        switch(choice_remove) {
            case 0:
                break;
            case 1:
            default:
                ma.removeMusikstueck(1);
        }
        System.out.println("Kontrolle des Musikalbums:\n"+ma.listMusikstuecke());
    }
}
