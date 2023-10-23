import javax.swing.JOptionPane;

/**
 * Sinn des Programmes wie in G2a.2.5, jedoch wird das Rechteck mit den Methoden
 * aus der Klasse 'Muster' geschrieben.
 * 
 * @author Andreas Suender
 * @version 2020-03-07
 */
class RechteckMitMethode {
    public static void main(String[] arg) {
        int hoehe = Integer.parseInt(JOptionPane.showInputDialog(null, "Bitte Höhe eingeben."));
        int breite = Integer.parseInt(JOptionPane.showInputDialog(null, "Bitte Breite eingeben."));
        String zeichen = JOptionPane.showInputDialog(null, "Bitte ein Zeichen eingeben.");

        /**
         * Sinn des Programmes wie in G2a.2.5, jedoch wird das Rechteck mit den Methoden
         * aus der Klasse 'Muster' geschrieben.
         * 
         * @author Andreas Suender
         * @version 2020-03-07
         */
        System.out.print(Muster.rechteck(zeichen, hoehe, breite));
    }
}