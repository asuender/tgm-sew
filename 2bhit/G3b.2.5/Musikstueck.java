/**
 * Die Klasse speichert ein einziges Musikstück mit den netwendigen
 * Daten wie Titel, Interpret und Dauer.
 * @author Andreas Sünder
 * @version 11-23-2020
 */
public class Musikstueck {
	/* Auch eine gute Möglichkeit, dies so zu lösen:
	 * Somit können bei manchen Konstruktoren bestimmte Attribute ausgelassen werden,
	 * weil sie schon hier initialisiert wurden.
	 */
	private String titel = "";
	private String interpret = "";
	private int dauer = 0;
	
	/**
	 * Erzeugt eine "leeres" Musikstück.
	 */
	public Musikstueck() {}
	/**
	 * Erzeugt ein Musikstück mit Titel und Dauer,
	 * falls der Autor unbekannt ist.
	 * @param titel Titel des Stücks
	 * @param dauer Dauer des Stücks in Sekunden
	 */
	public Musikstueck(String titel, int dauer) { // für Musikstücke mit unbekanntem Autor
		this.titel = titel;
		this.dauer = dauer;
	}
	/**
	 * Erzeugt ein Musikstück mit allen möglichen Werten.
	 * @param titel Titel des Stücks
	 * @param interpret Interpret des Stücks
	 * @param dauer Dauer des Stücks
	 */
	public Musikstueck(String titel, String interpret, int dauer) {
		this.titel = titel;
		this.interpret = interpret;
		this.dauer = dauer;
	}
	
	/**
	 * Liefert den Titel zurück.
	 * @return Titel des Stücks
	 */
	public String getTitel() {
		return titel;
	}
	/**
	 * Liefert den Interpreten zurück.
	 * @return Interpret des Stücks
	 */
	public String getInterpret() {
		return interpret;
	}
	/**
	 * Liefert die Dauer in Sekunden zurück.
	 * @return Dauer des Stücks
	 */
	public int getDauer() {
		return dauer;
	}
	
	/**
	 * Setzt den gewünschten Titel für das Stück.
	 * @param titel Titel des Stücks
	 */
	public void setTitel(String titel) {
		this.titel = (!titel.isEmpty()) ? titel : this.titel;
	}
	/**
	 * Setzt den gewünschten Interpreten für das Stück.
	 * @param interpret Interpret des Stücks
	 */
	public void setInterpret(String interpret) {
		this.interpret = interpret;
	}
	/**
	 * Setzt die Dauer für das Stück in Sekunden
	 * @param dauer Dauer des Stücks
	 */
	public void setDauer(int dauer) {
		this.dauer = (dauer > 0) ? dauer : this.dauer;
	}
	
	
	/**
	 * Liefert die Dauer des Stücks als String zurück im Format 'mm:ss'.
	 * @return String-Repräsentation der Dauer
	 */
	public String zeigeDauer() {
		int min = dauer/60;
		int sec = dauer%60;
		return min+":"+sec;
	}
	/**
	 * Liefert alle Daten des Stücks als String zurück.
	 * @return String-Repräsentation des Stücks
	 */
	public String zeigeDaten() {
		return "**Daten dieses Musikstückes**\nTitel: "+titel+"\nInterpret: "+interpret+"\nDauer: "+dauer;
	}

	
	/**
	 * Erstellt eine tiefe Kopie dies aktullen Musikstücks
	 * und gibt dieses zurück.
	 * @return kopiertes Musikstück
	 */
	public Musikstueck clone() {
		return new Musikstueck(titel, interpret, dauer);
	}
}
