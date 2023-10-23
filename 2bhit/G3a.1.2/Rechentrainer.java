import java.util.Scanner;

/**
 * Dieses Programm ist ein kleiner "Rechentrainer".
 * Der Benutzer soll 2 Zufallszahlen addieren/subtrahieren/multiplizieren/dividieren. Dies darf
 * von ihm ausgesucht werden. Das Programm überprüft darauf die Eingabe des Anwenders.
 * Solange das "Spiel" nach jedem Vorgang nicht abgebrochen wird,
 * wird es endlos fortgesetzt.
 * @author Andreas Suender
 * @version 21-09-2020
 */
public class Rechentrainer {
    public static void main(String[] args) {
        // Deklarieren wir hier die Variablen, sonst werden diese beim jeden
        // Vorgang gelöscht und neu erzeugt
        Scanner console = new Scanner(System.in);
        int max, r_num1, r_num2, erg=0, erg_user, anws_wrong=0, anws_right=0;
        boolean continue_;
        char op;
        
        do {
            System.out.print("Bitte die Obergrenze eingeben: ");
            max = console.nextInt();
            
            System.out.print("Bitte einen Rechenoperator eingeben: ");
            op = console.next().charAt(0);
            
            r_num1 = Zufallszahlen.zufall(max);
            r_num2 = Zufallszahlen.zufall(max);
            
            
            switch(op) {
                case '+':
                    erg = r_num1 + r_num2;
                    break;
                case '-':
                    erg = r_num1 - r_num2;
                    break;
                case '*':
                    erg = r_num1 * r_num2;
                    break;
                case '/':
                    erg = r_num1 / r_num2;
                    break;
            }
            
            System.out.print(r_num1 + "" + op + "" + r_num2 + " = ? ");
            erg_user = console.nextInt();
            
            if (erg == erg_user) {
                System.out.println("Richtig!");
                anws_right++;
            }
            else {
                System.out.println("Falsch!");
                anws_wrong++;
            }
            System.out.println(r_num1 + " + " + r_num2 + " = " + erg);
            
            System.out.println("Noch ein Versuch? ");
            continue_ = console.nextBoolean();
        }
        while(continue_ == true);
        
        // Einfache Statistik
        System.out.println("Richtige / falsche Antworten: "+anws_right+"/"+anws_wrong);
    }
}
