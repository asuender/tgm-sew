import java.util.Random;

/**
 * Diese Klasse beinhaltet 2 Methoden zum Erzeugen eines Arrays mit gegebener Länge,
 * welches Zufallszahlen beinhaltet und zum Umwandeln eines Array-Objekts
 * in reine Textform.
 * @author Andreas Suender
 * @version 2020-11-02
 */
public class ArrayMethoden {
	/**
	 * Erzeugt ein Array mit der Länge 'upperbound', welches dann mit
	 * Zufallszahl zwischen 0 und 'upperbound'*2 gefüllt wird.
	 * @param upperbound Anzahl der Stellen im Array
	 * @return das erzeugte Array
	 */
	public static int[] zufallsArray (int upperbound) {
		int[] randomArray = new int[upperbound];
		
		Random generator = new Random();
		
		for (int i=0; i<randomArray.length; i++)
			randomArray[i] = generator.nextInt(upperbound*2);
			
		return randomArray;
	}
	
	/**
	 * Wandelt ein Array in reine Textform um der Form
	 * [1],[2],[3], ...
	 * @param array das zu umwandelnde Array
	 * @return Textfrom des Arrays
	 */
	public static String arrayToText(int[] array) {
		String res = "";
		for (int i=0; i<array.length; i++) {
			res += array[i]+",";
		}
		return res;
	}
}
