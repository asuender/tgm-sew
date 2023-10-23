import java.util.Random;

/**
 * Diese Klasse speichert ein Objekt mit einem int[] Array,
 * welche viele nette Methoden bietet, um das Attribut zu manipulieren.
 * @author Andreas Sünder
 * @version 2020-11-02
 */
public class Zahlenarray {
	private int[] array;
	
	/**
	 * Erzeugt ein Array mit der Länge 5, welches dann mit
	 * Zufallszahlen zwischen 0 und 5*2, also 10, gefüllt wird.
	 * @param upperbound Anzahl der Stellen im Array
	 */
	Zahlenarray() {
		this(5);
	}
	
	/**
	 * Erzeugt ein Array mit der Länge 'upperbound', welches dann mit
	 * Zufallszahlen zwischen 0 und 'upperbound'*2 gefüllt wird.
	 * @param upperbound Anzahl der Stellen im Array
	 */
	Zahlenarray(int upperbound) {
		array = new int[upperbound];
		
		Random generator = new Random();
		
		for (int i=0; i<array.length; i++)
			array[i] = generator.nextInt(upperbound*2);
	}
	
	
	/**
	 * Füllt das Array mit Zufallszahlen zw. 0 und 'upperbound'*2;
	 * @param upperbound Anzahl der Stellen im Array
	 * @return das erzeugte Array
	 */
	public void zufallsArray(int upperbound) {
		Random generator = new Random();
		
		for (int i=0; i<array.length; i++)
			array[i] = generator.nextInt(upperbound*2);
	}
	
	/**
	 * Wandelt das Array in reine Textform um der Form
	 * [1],[2],[3], ...
	 */
	public String arrayToText() {
		String res = "";
		for (int i=0; i<array.length; i++)
			res += array[i]+",";
		return res;
	}
	
	/**
	 * Spiegelt das gespeicherte Array.
	 */
	public void umdrehen () {
		int[] mirrored = new int[array.length];
		
		int i=0;
		for (int x=array.length-1; i<array.length && x>=0; i++, x--) 
			mirrored[i] = array[x];
		array = mirrored;
	}	
}
