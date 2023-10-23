import java.util.Scanner;

/**
 * Diese Programmcode testet die Klasse 'Punkt2D', indem Objekte derselben erzeugt
 * und alle Methoden getestet werden.
 * @author Andreas Suender
 * @version 2020-10-12
 */
public class Test {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        Punkt2D p = new Punkt2D();
        
        System.out.print("X: ");
        p.setX(Integer.parseInt(console.nextLine()));
        System.out.print("Y: ");
        p.setY(Integer.parseInt(console.nextLine()));
        System.out.println("X/Y sind jetzt: "+p.textDaten());
        
        System.out.println("Abstand zum Nullpunkt: "+p.abstandNull()+"\n");
        
        System.out.print("Bitte geben Sie einen X und einen Y Wert für ein neues Punkt2D-Objekt im Format x/y ein: ");
        String x_y = console.nextLine();
        
        int pos_slash = x_y.indexOf('/');
        int x_p2 = Integer.parseInt(x_y.substring(0, pos_slash));
        int y_p2 = Integer.parseInt(x_y.substring(pos_slash+1));
        
        Punkt2D p2 = new Punkt2D(x_p2, y_p2);
        
        System.out.println("Das neu erzeugte Objelkt ist "+ (p.equals(p2) ? "gleich" : "ungleich") + " dem ersten.");
        System.out.println("Abstand zwischen p und p2: "+ p.abstand(p2));
        console.close();
    }
}
