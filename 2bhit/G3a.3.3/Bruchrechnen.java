import java.util.Scanner;

/**
 * Testet und veranschaulicht die Benutzung der Klasse 'Bruchzahl'.
 * @author Andreas Sünder
 * @version 2020-11-04
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
		
		System.out.print("\nKontrolle: "+b.textForm() + "\nDezimalwert: "+b.dezimalWert()+"\n");
		
		System.out.print("Bruch erweitern(1) oder kürzen (2) ?: ");
		int user_choice = Integer.parseInt(console.nextLine());
		
		switch(user_choice) {
			default:
			case 1:
				System.out.print("Bitte auch einen Wert zum Erweitern eingeben: ");
				int user_value  = console.nextInt(); 
				b.erweitern(user_value);
				break;
			case 2:
				b.kuerzen();
				
		}
		System.out.println("Kontrolle: "+b.textForm() + "\nDezimalwert: "+b.dezimalWert());
		
		System.out.print("\nBruch addieren(1), subtrahieren(2), multiplizieren(3) oder dividieren(4): ");
		user_choice = Integer.parseInt(console.nextLine());
		
		System.out.print("Bitte Zähler & Nenner für die zweite Bruchzahl im Format Z/N eingeben: ");
		Bruchzahl b2 = erstelleBruchzahl(console.nextLine());
		
		switch(user_choice) {
			default:
			case 1:
				b = b.addiere(b2);
				break;
			case 2:
				b = b.subtrahiere(b2);
				break;
			case 3:
				b = b.multipliziere(b2);
				break;
			case 4:
				b = b.dividiere(b2);
				break;
		}
		
		System.out.println("Kontrolle: "+b.textForm() + "\nDezimalwert: "+b.dezimalWert());
		System.out.print("Kehrwert des Bruches: "+b.invertiere().textForm());
	}
}
