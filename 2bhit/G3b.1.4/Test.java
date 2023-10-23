import java.util.Scanner;

/**
 * Testet die 'Zahlenarray' Klasse.
 * @author Andreas Suender
 * @version 2020-11-02
 */
public class Test {
	public static void main(String[] args) {
		// wiederrum hier alles in der Kommandozeile
		Scanner console = new Scanner(System.in);
		
		System.out.println("Bitte geben Sie die Länge des gewünschten Arrays ein: ");
		int numInput = Integer.parseInt(console.nextLine());
		
		Zahlenarray z = new Zahlenarray(numInput);
		
		System.out.println("Das erzeugte Array: "+z.arrayToText());
		
		z.umdrehen();
		System.out.println("Umgedreht: "+ z.arrayToText());
		
		//safety first:
		console.close();
	}
}
