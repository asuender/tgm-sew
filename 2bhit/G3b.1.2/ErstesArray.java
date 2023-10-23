import java.util.Scanner;

/**
 * Dieses kleine Programm erzeugt ein Array mit Dezimalzahlen
 * mit einer Länge, die vom Benutzer entschieden werden muss.
 * Zusätzlich wird er beauftragt, jedes Element einer Zahl zuzuweisen.
 * @author Andreas Sünder
 * @version 2020-10-11
 */
public class ErstesArray {
	public static void main(String[] args) {
		// Ich mag JOptionPane nicht, daher verwenden wir Scanner
		Scanner console = new Scanner(System.in);
		
		System.out.print("Es wird ein neues Array erzeugt mit double-Werten. Wie lang soll es sein? ");
		int amount = console.nextInt();
		
		double[] doubleArray = new double[amount];
		for (int i=0; i<doubleArray.length; i++) {
			System.out.print("Bitte die "+ (i+1) + ". Zahl für das Array eingeben: ");
			doubleArray[i] = console.nextDouble();
		}
		
		for (int j=0; j<doubleArray.length; j++)
			System.out.println("doubleArray["+j+"] = "+doubleArray[j]);
		
	}
}
