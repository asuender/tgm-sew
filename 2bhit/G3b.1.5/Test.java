import java.util.Scanner;

/**
 * Testet und veranschaulicht die Benutzung aller Methoden der
 * 'ArrayMethoden' Klasse.
 * @author Andreas Suender
 * @version 2020-11-10
 */
public class Test {
	public static void main(String[] args) {
		// wiederrum hier alles in der Kommandozeile
		Scanner console = new Scanner(System.in);
		
		System.out.println("Bitte geben Sie die Länge des gewünschten Arrays ein: ");
		int numInput = Integer.parseInt(console.nextLine());
		
		int[] array = ArrayMethoden.zufallsArray(numInput);
		
		System.out.println("Das erzeugte Array: "+ArrayMethoden.arrayToText(array));
		
		// alle neuen Methoden werden hier getestet:
		System.out.print("\nMit welcher Zahl soll das Array gefüllt werden? ");
		ArrayMethoden.fillArray(array, console.nextInt());
		System.out.println("Kontrolle "+ArrayMethoden.arrayToText(array));
		
		System.out.print("\nDas Array soll mit Zufallszahlen befüllt werden.\nGeben Sie die  Ober- und Untergrenze an: ");
		int from = console.nextInt();
		int to   = console.nextInt();
		ArrayMethoden.fillZufallArray(array, from, to);
		System.out.println("Kontrolle "+ArrayMethoden.arrayToText(array));
		
		System.out.print("Welche zwei Elemente (Index) sollen vertauscht werden? ");
		int index1 = console.nextInt();
		int index2 = console.nextInt();
		ArrayMethoden.vertausche(array, index1, index2);
		System.out.println("Kontrolle "+ArrayMethoden.arrayToText(array));
	}
}
