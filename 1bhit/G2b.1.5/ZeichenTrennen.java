import javax.swing.JOptionPane;

/**
 * ZeichenTrennen
 * Der Benutzer gibt einen beliebigen Text ein, dieser Wird zerlegt und zwischen jedem
 * Zeichen ein Komma eingefügt (außer am Ende). Das Resultat + Anzahl der Zeichen werden dann ausgegeben.
 * @author Andreas Suender
 * @version 2020-03-30
 */
public class ZeichenTrennen {
    public static void main(String[] args) {
        String input = JOptionPane.showInputDialog(null, "Bitte einen Text eingeben:");
        JOptionPane.showMessageDialog(null, "Eingabe: "+input+"\n"+"Anzahl der Zeichen: "+input.length()+"\n"+"Zeichen:\n"+Zeichentools.trenne(input));
    }
}