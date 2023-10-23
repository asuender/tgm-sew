import java.util.Scanner;

/**
 * Testet die Klassenmethode 'invertierte' der 'Bruchzahl' Klasse.
 * @author Andreas Sünder
 * @version 2020-11-05
 */
public class Bruchrechnen {
	/**
     * Erzeugt ein neues 'Bruchzahl' Objekt aus einem String der Form "Z/N".
     * @param values String mit den gewünschten Werten
     * @return neues 'Bruchzahl' Objekt
     */
	public static Bruchzahl erstelleBruchzahl(String values) {
        Bruchzahl b = new Bruchzahl();
        int pos_slash = values.indexOf('/');
        b.setZaehler(Integer.parseInt(values.substring(0, pos_slash)));
        b.setNenner(Integer.parseInt(values.substring(pos_slash+1)));
        return b;
    }
	
	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);
		
		System.out.print("Bitte Zähler & Nenner für die neue Bruchzahl im Format Z/N eingeben: ");
		Bruchzahl b = erstelleBruchzahl(console.nextLine());
		
		System.out.println("Kontrolle: "+b.textForm() + "\nDezimalwert: "+b.dezimalWert());
		
		Bruchzahl.invertiere(b);
		System.out.println("Kehrwert: "+b.textForm());		
	}
}
