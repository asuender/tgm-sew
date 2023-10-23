
/**
 * Erweitertes Programm.
 * Produziert ähnlich wie bei 'Sternchen_Rechteck' ein Rechteck.
 * Dieses ist aber nicht ausgefüllt (Hohlraum).
 *
 * @author Andreas Suender
 * @version 2019-02-15
 */
public class Hohles_Rechteck
{
    public static void main(String[] args) {
        //Deklarationen der Variablen
        int hoehe=5;
        int breite=10;
        
        //Hauptteil
        for (int i=0; i<hoehe; i++) {
            if (i==0 || i==hoehe-1) {
                for (int j=0; j<breite-1; j++) {
                    System.out.print("*");
                }
                System.out.println("*");
            }
            else {
                System.out.print("*");
                for (int j=0; j<breite-2; j++) System.out.print(" ");
                System.out.println("*");
            }
        }
    }
}
