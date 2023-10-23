import java.util.Scanner;
import java.util.Random;

/**
 * Testet die letzten beiden Methoden ('kopiere') der Klasse
 * 'ArrayMethoden'.
 * @author Andreas Suender
 * @version 10-12-2020
 */
public class Test {
	public static void main(String[] args) {
		// wiederrum hier alles in der Kommandozeile
		Scanner console = new Scanner(System.in);
		Random generator = new Random();
		
		int[] a = new int[10];
		for (int i=0; i<a.length; i++)
			a[i] = generator.nextInt(20);

		System.out.println("Erstelltes Array:");
		for (int i=0; i<a.length; i++)
			System.out.print(a[i]+" ");

		System.out.print("\nSoll das Array vergrößert (1) oder verkleinert werden (2)? :");
		int choice = console.nextInt();

		System.out.print("Bitte noch den Wert zum Vergrößern/Verkleinern eingeben: ");
		int param = console.nextInt();

		int a2[] = new int[]{};
		switch(choice) {
			case 1:
				a2 = ArrayMethoden.vergroessern(a, param);
				break;
			case 2:
				a2 = ArrayMethoden.verkleinern(a, param);
				break;
			default:
				System.exit(1);
		}

		System.out.println("\nneues Array:");
		for (int i=0; i<a2.length; i++)
			System.out.println("["+i+"] "+a2[i]);
	}
}
