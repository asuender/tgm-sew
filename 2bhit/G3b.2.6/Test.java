import java.util.Scanner;
import java.util.Random;

/**
 * Testet die letzten beiden Methoden ('kopiere') der Klasse
 * 'ArrayMethoden'.
 * @author Andreas Suender
 * @version 30-11-2020
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

		int[] a_c = ArrayMethoden.kopiere(a);
		System.out.println("\nDas Array wurde kopiert. Bitte zum Testen den Index der Zahl im Ursprungsarray eingeben, um sie zu ändern:");
		int index = console.nextInt();
		a[index] = generator.nextInt(20);

		System.out.println("Array a:");
		for (int i=0; i<a.length; i++)
			System.out.print(a[i]+" ");
		System.out.println("\nArray a_c:");
		for (int i=0; i<a_c.length; i++)
			System.out.print(a_c[i]+" ");

		System.out.println();
		// ======== ======== ======== ======== ========
		
		int[][] am = new int[10][10];
		for (int i=0; i<am.length; i++) {
			for (int j=0; j<am[i].length; j++)
				am[i][j] = generator.nextInt(20);
		}

		System.out.println("Erstelltes Array:");
		for (int i=0; i<am.length; i++) {
			System.out.print("[");
			for (int j=0; j<am.length; j++)
				System.out.print(am[i][j]+" ");
			System.out.print("] ");
		}

		int[][] am_c = ArrayMethoden.kopiere(am);
		System.out.println("\nZum Testen wird im Ursprungsarray der Wert im Index [1][1] geändert:");
		am[1][1] = generator.nextInt(20);

		System.out.println("Array am:");
		for (int i=0; i<am.length; i++) {
			System.out.print("[");
			for (int j=0; j<am.length; j++)
				System.out.print(am[i][j]+" ");
			System.out.print("] ");
		}
		System.out.println("\nArray am_c:");
		for (int i=0; i<am_c.length; i++) {
			System.out.print("[");
			for (int j=0; j<am_c.length; j++)
				System.out.print(am_c[i][j]+" ");
			System.out.print("] ");
		}

		System.out.println(); // Newline am Ende
	}
}
