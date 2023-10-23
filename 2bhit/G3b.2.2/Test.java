import java.util.Scanner;

/**
 * Diese Klasse testet die Klasse 'NumberSquare' und veranschaulicht ihre Nutzung.
 * Der Benutzer wird aufgefordert, eine Art Matrix einzugeben, die dann auf 
 * ein mögliches, "magisches Quadrat" geprüft wird.
 * @author Andreas Suender
 * @version 11-27-2020
 */
public class Test {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        System.out.println("Bitte die Kante (Spalten- bzw. Zeilenanzahl) für das Quadrat eingeben: ");
        int kante = Integer.parseInt(console.nextLine());
        NumberSquare ns = new NumberSquare(kante);

        System.out.println("Bitte alle Zahlen im Format x,y,z, .. eingeben: ");
        String[] splitted_input = console.nextLine().split(",");

        // Diese Schleife brauchen Sie nicht zu verstehen ...
        // Im Endeffekt parst sie nur die eingegebenen Werte von oben in das ns Objekt
        int row = 0;
        int column = 0;
        for (int i=0; i<splitted_input.length && row<kante; i++, column++) {
            if (i> 0 && i % kante == 0) { row++; column=0; }
            ns.setNumber(row, column, Integer.parseInt(splitted_input[i]));
        }

        System.out.println("Das eingegebene Quadrat ist " + (ns.isMagicSquare() ? "ein" : "kein") + " magisches Quadrat.");
        System.out.println("Kontrolle:\n"+ns.stringForm());
    }
}
