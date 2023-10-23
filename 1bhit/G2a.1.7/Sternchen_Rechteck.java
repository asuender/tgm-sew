
/**
 * Dieses Programm schreibt ein (ausgefülltes) Rechteck mittels Sternchen.
 * Die Höhe und Breite kann verändert werden.
 *
 * @author Andreas Sünder
 * @version 2019-02-15
 */
public class Sternchen_Rechteck
{
    public static void main(String[] args) {
        int hoehe = 10;
        int breite = 5;
        
        for (int i=0; i<hoehe; i++) {
            for (int j=0; j<breite-1; j++) {
                System.out.print("*");
            }
            System.out.println("*");
        }
    }
}
