import java.util.Scanner;

/**
 * Testet und veranschaulicht die Benutzung aller Methoden der
 * 'ArrayMethoden' Klasse.
 * @author Andreas Suender
 * @version 2020-11-02
 */
public class Test {
	public static void main(String[] args) {
		// wiederrum hier alles in der Kommandozeile
		Scanner console = new Scanner(System.in);
		
		System.out.println("Bitte geben Sie die Länge des gewünschten Arrays ein: ");
		int numInput = Integer.parseInt(console.nextLine());
		
		int[] array = ArrayMethoden.zufallsArray(numInput);
		
		System.out.println("Das erzeugte Array: "+ArrayMethoden.arrayToText(array));
		
		//safety first:
		console.close();
	}
}
