import java.util.Scanner;

/**
 * Die Klasse testet und die beiden Klassen 'Musikstueck' und 'MusikAlbum' und zeigt damit auch,
 * dass die clone()-Methoden richtig funktionieren.
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
        int m_dauer = Integer.parseInt(console.nextLine());

        Musikstueck m = new Musikstueck(m_titel, m_interpret, m_dauer);

        System.out.println("\nKontrolle: \n"+m.zeigeDaten());
        
        System.out.println("=======================");
        
        System.out.println("Erstellen wir ein neues Musikalbum. Wie soll es heißen?"); 
        String ma_name = console.nextLine();
        System.out.println("Bitte geben Sie den Interpreten für das Musikalbum ein: ");
        String ma_interpret = console.nextLine();
        System.out.println("Wie viele Musikstuecke soll es beinhalten? :");
        byte ma_anzahl = Byte.parseByte(console.nextLine());
        MusikAlbum ma = new MusikAlbum(ma_name, ma_interpret, ma_anzahl);

        ma.addMusikstueck(m);

        MusikAlbum ma_clone = ma.clone();

        System.out.println("Das erzeugte Album wurde geklont.\n"+
        "Soll zum Testen aber entweder der Titel(1), Interpret(2) oder die Dauer(3) des 1. Stücks geändert werden? :");
        int choice = Integer.parseInt(console.nextLine());
        System.out.println("Bitte noch einen Wert dafür eingeben: ");
        String value = console.nextLine();
        switch(choice) {
            default:
            case 1:
                ma.changeTitel(0, value);
                break;
            case 2:
                ma.changeInterpret(0, value);
                break;
            case 3:
                ma.changeDauer(0, Integer.parseInt(value));
                break;
        }

        System.out.println("Kontrolle beider Musikalben:\n"+ma.listMusikstuecke()+"\n"+ma_clone.listMusikstuecke());
    }
}
