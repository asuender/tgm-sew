/**
 * Speichert eine einfache Bruchzahl mit Zähler und Nenner und enthält Methoden
 * zur einfachen Manipulation.
 * @author Andreas Sünder
 * @version 2020-11-05
 */
public class Bruchzahl {
	private int zaehler;
	private int nenner;
	
	/**
	 * Erzeugt eine Bruchzahl mit 0/1.
	 */
	public Bruchzahl() {
		this(0, 1);
	}
	
	/**
	 * Erzeugt eine Bruchzahl mit den gewünschten Werten.
	 * @param z Zähler
	 * @param n Nenner
	 */
	public Bruchzahl(int z, int n) {
		zaehler = z;
		nenner = n != 0 ? n : 1; 
	}
	
	/**
	 * Setzt den Zähler auf den gewünschten Wert.
	 * @param z gewünschter Wert
	 */
	public void setZaehler(int z) {
		zaehler = z;
	}
	
    /**
	 * Setzt den Nener auf den gewünschten Wert.
	 * @param n gewünschter Wert
	 */
	public void setNenner(int n) {
		nenner = n != 0 ? n : 1;
	}
	
	/**
	 * Gibt den Zähler zurück.
	 * @return Zähler
	 */
	public int getZaehler() {
		return zaehler;
	}
	
	/**
	 * Gibt den Nenner zurück.
	 * @return Nenner
	 */
	public int getNenner() {
		return nenner;
	}
	
	
	/**
	 * Gibt die Bruchzahl als Form "Z/N".
	 * @return Textform der Bruchzahl
	 */
	public String textForm() {
		return "" + zaehler + " / " + nenner;
	}
	
	/**
	 * Gibt den Dezimalwert der Bruchzahl zurück.
	 * @return Dezimalwert
	 */
	public double dezimalWert() {
		return (double)zaehler / nenner;
	}
	
	/**
	 * Erweitert den Bruch um die gegebene Zahl.
	 * @param factor Faktor zum Erweitern
	 */
	public void erweitern(int factor) {
		zaehler = zaehler*factor;
		nenner  = nenner*factor;
	}
	
	/**
	 * Kürzt den Bruch soweit wie möglich.
	 */
	public void kuerzen() {
		int div = ggT(zaehler, nenner);
		zaehler = zaehler / div;
		nenner = nenner / div;
	}
	
	/**
	 * Berechnet den ggT aus den zwei gegebenen Werten.
	 * @param a 1.Wert
	 * @param b 2.Wert
	 * @return ggT der beiden Zahlen
	 */
	public static int ggT(int a, int b) {
		int rest = 1;
		while (rest != 0) {
			rest = a%b;
			
			if (rest != 0) {
				a = b;
				b = rest;
			}
		}
		return b;
	}
	
	/**
	 * Addiert die gegebene Bruchzahl und gibt die Summe zurück.
	 * @param andereBruchzahl die zu addierende Bruchzahl
	 * @return Summe
	 */
	public Bruchzahl addiere(Bruchzahl andereBruchzahl) {
		int hn = (this.nenner*andereBruchzahl.nenner)
				  / ggT(this.nenner, andereBruchzahl.nenner);
		int factor1 = hn/this.nenner;
		int factor2 = hn/andereBruchzahl.nenner;
		
		return new Bruchzahl(
			(this.zaehler*factor1)+(andereBruchzahl.zaehler*factor2),
			hn
		);
	}
	
	/**
	 * Subtrahiert die gegebene Bruchzahl und gibt die Differenz zurück.
	 * @param andereBruchzahl die zu subtrahierende Bruchzahl
	 * @return Differenz
	 */
	public Bruchzahl subtrahiere(Bruchzahl andereBruchzahl) {
		int hn = (this.nenner*andereBruchzahl.nenner)
				  / ggT(this.nenner, andereBruchzahl.nenner);
		int factor1 = hn/this.nenner;
		int factor2 = hn/andereBruchzahl.nenner;
		
		return new Bruchzahl(
			(this.zaehler*factor1)-(andereBruchzahl.zaehler*factor2),
			hn
		);
	}
	
	/**
	 * Multipliziert die gegebene Bruchzahl und gibt das Produkt zurück.
	 * @param andereBruchzahl die zu multiplizierende Bruchzahl
	 * @return Produkt
	 */
	public Bruchzahl multipliziere(Bruchzahl andereBruchzahl) {
		return new Bruchzahl(
			this.zaehler*andereBruchzahl.zaehler,
			this.nenner *andereBruchzahl.nenner
		);
	}
	
	/**
	 * Dividiert die gegebene Bruchzahl und gibt den Quotienten zurück.
	 * @param andereBruchzahl die zu dividierende Bruchzahl
	 * @return Quotienten
	 */
	public Bruchzahl dividiere(Bruchzahl andereBruchzahl) {
		return multipliziere(
			new Bruchzahl(andereBruchzahl.nenner, andereBruchzahl.zaehler)
		);
	};
	
	/**
	 * Dreht den Bruch um und gibt das Resultat zurück.
	 * @return Kehrwert
	 */
	public Bruchzahl invertiere() {
		return new Bruchzahl(
			this.nenner,
			this.zaehler
		);
	}
	
	/**
	 * Dreht den gegebenen Bruch um.
	 * @param b Bruchzahl, dessen Kehrwert gebildet werden soll.
	 */
	public static void invertiere(Bruchzahl b) {
		int tmp = b.zaehler;
		b.zaehler = b.nenner;
		b.nenner = tmp;
	}
}
