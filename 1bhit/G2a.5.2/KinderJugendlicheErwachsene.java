import javax.swing.JOptionPane;
/**
 *  Dieses Programm zählt, wie viele Kinder, Jugendliche oder 
 *  Erwachsene bei der Eingabe des Alters vorkommen. Kinder sind 
 *  alle Personen von 0 bis 14 Jahren, Jugendliche von 14 bis 18
 *  und Erwachsene ab 18. Negative Eingaben beenden das Programm.
 *  @author Andreas Sünder
 *  @version 2020-03-20
 */
public class KinderJugendlicheErwachsene {
    public static void main(String[] args) {
        String eingabe;
        int alter;
        int anzKinder = 0;
        int anzJugendliche = 0;
        int anzErwachsene = 0;
        do {
            eingabe = JOptionPane.showInputDialog(null,
                "Welches Alter hat die zu zählende Person?");
            alter = Integer.parseInt(eingabe);
            //if(alter <= 14) {
            if(alter >= 0 && alter < 14) {
                anzKinder++;
            }
            //if(alter>=14 && alter < 18) {
            if(alter>=14 && alter < 18) {
                anzJugendliche++;
            }
            //if(alter > 18) {
            if(alter >= 18) {
                anzErwachsene++;
            }
        } while(alter >= 0);
    
        JOptionPane.showMessageDialog(null, "Kinder: " + anzKinder +
            "\nJugendliche: " + anzJugendliche + "\nErwachsene: "
            + anzErwachsene);
    }
}