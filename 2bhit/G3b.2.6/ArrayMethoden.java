import java.util.Random;

/**
 * Diese Klasse enthält Methoden zum Erzeugen und einfachen Manipulieren von Arrays.
 * @author Andreas Suender
 * @version 30-11-2020
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
	
	/**
	 * Füllt das Array mit der gegebenen Zahl.
	 * @param array das zu füllende Array
	 * @param num Zahl, die eingesetzt werden soll
	 */
	public static void fillArray(int[] array, int num) {
		for (int i=0; i<array.length; i++)
			array[i] = num;
	}
	
	/**
	 * Füllt das Array mit Zufallszahlen zwischen 'from' und 'to';
	 * @param array das zu füllende Array
	 * @param from Untergrenze
	 * @param to Obergrenze
	 */
	public static void fillZufallArray(int[] array, int from, int to) {
		Random generator = new Random();
		
		for (int i=0; i<array.length; i++)
			array[i] = generator.nextInt(to)+from;
	}
	
	/**
	 * Vertauscht die zwei Elemente mit den gegebenen Indexen.
	 * @param array das gegebene Array
	 * @param index1 erstes Element
	 * @param index2 zweites Element
	 */
	public static void vertausche(int[] array, int index1, int index2) {
		int tmp = array[index1];
		array[index1] = array[index2];
		array[index2] = tmp;
	}

	/**
	 * Übernimmt ein ganzzahliges Array, kopiert es
	 * und gibt die tiefe Kopie zurück.
	 * @param array Array, welches kopiert werden soll
	 * @return Kopiertes Array
	 */
	public static int[] kopiere(int[] array) {
		int[] copied = new int[array.length];
		for (int i=0; i<copied.length; i++)
			copied[i] = array[i];
		return copied;
	}

	/**
	 * Übernimmt ein mehrdimensionales Array, kopiert es
	 * und gibt die tiefe Kopie zurück.
	 */
	public static int[][] kopiere(int[][] array) {
		int[][] copied = new int[array.length][]; // ermöglicht das Kopieren
												  // dynamischer Arrays
		for (int i=0; i<array.length; i++) {
			copied[i] = new int[array[i].length];
			for (int j=0; j<array[i].length; j++)
				copied[i][j] = array[i][j];
		}
		return copied;
	}
}
