import javax.swing.JOptionPane;

/**
 * Dieses Programm schreibt ein (ausgefülltes) Rechteck mittels Sternchen.
 * Die Höhe und Breite müssen vom Benutzer durch ein Fenster eingeben werden.
 *
 * @author Andreas Sünder
 * @version 2020-03-02
 */
public class RechteckMitEingabe
{
    public static void main(String[] args) {
        int hoehe = Integer.parseInt(JOptionPane.showInputDialog(null, "Bitte Höhe eingeben."));
        int breite = Integer.parseInt(JOptionPane.showInputDialog(null, "Bitte Breite eingeben."));
        String zeichen = JOptionPane.showInputDialog(null, "Bitte ein Zeichen eingeben.");
        
        for (int i=0; i<hoehe; i++) {
            // hier muss jeweils ein Sternchen weniger gemacht werden ...
            for (int j=0; j<breite-1; j++) {
                System.out.print(zeichen);
            }
            // ... damit hier das letzte mit einem Newline gezichnet werden kann.
            System.out.println(zeichen);
        }
    }
}
