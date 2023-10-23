import javax.swing.JOptionPane;

/**
 * Noteneingabe
 */
public class Noteneingabe {
    public static void main(String[] args) {
        int grade = Integer.parseInt(JOptionPane.showInputDialog(null, "Bitte eine Schulnote eingeben:"));
        JOptionPane.showMessageDialog(null, "Die zugehörige Ampelfarbe ist \""+Noten.ampelfarbe(grade)+"\"");
    }
}