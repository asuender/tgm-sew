import java.util.Scanner;

/**
 * Testet und veranschaulicht die Benutzung der Klasse "Dreieck" bzw. "Punkt2D".
 * @author Andreas Sünder
 * @version 2020-10-12
 */
public class Test {
    /**
     * Übernimmt einen String im Format x/y und gibt ein "Punkt2D"-Objekt
     * mit den dementsprechenden Werten zurück.
     * @param values Werte im Format x/y
     * @return Punkt2D-Objekt mit den X & Y- Werten
     */
    public static Punkt2D erstellePunkt(String values) {
        Punkt2D p = new Punkt2D();
        int pos_slash = values.indexOf('/');
        p.setX(Integer.parseInt(values.substring(0, pos_slash)));
        p.setY(Integer.parseInt(values.substring(pos_slash+1)));
        return p;
    }
    
    public static void main(String[] args) {
        Dreieck d = new Dreieck();
        Scanner console = new Scanner(System.in);
        
        // hier verwende ich die obige Methode, um den Code ein wenig zu vereinfachen
        // und lesbarer zu machen
        System.out.print("Bitte einen X und Y Wert für den 1.Punkt eingeben im Format x/y: ");
        d.setP1(erstellePunkt(console.nextLine()));
        System.out.print("Bitte einen X und Y Wert für den 2.Punkt eingeben im Format x/y: ");
        d.setP2(erstellePunkt(console.nextLine()));
        System.out.print("Bitte einen X und Y Wert für den 3.Punkt eingeben im Format x/y: ");
        d.setP3(erstellePunkt(console.nextLine()));
        
        // Ausgabe der Koordinaten aller Punkte und des Umfangs vom Dreieck
        System.out.println("\nKoordinaten aller Punkte:\n"+d.toString());
        System.out.println("\nUmfang des Dreiecks: "+d.umfang());
        
        
        console.close();
    }
}
