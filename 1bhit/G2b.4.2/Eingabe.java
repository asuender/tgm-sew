import javax.swing.JOptionPane;

/**
 * Eingabe
 * 
 * Der Benutzer muss eine Email-Adresse eingeben und ein Domain-Level als Zahl.
 * Daraufhin werden Benutzer- und Domainteil bzw. das entsprechende Level
 * formatiert ausgegeben.
 * 
 * @author Andreas Suender
 * @version 2020-05-11
 */
public class Eingabe {
    /**
     * Der Benutzer muss eine Email-Adresse eingeben und ein Domain-Level als Zahl.
     * Daraufhin werden Benutzer- und Domainteil bzw. das entsprechende Level
     * formatiert ausgegeben
     * 
     * @param args not used
     */
    public static void main(String[] args) {
        String addr = JOptionPane.showInputDialog(null, "Bitte eine gültige Email-Addresse eingeben!");
        int level = Integer.parseInt(
                JOptionPane.showInputDialog(null, "Bitte ein Level eingeben, dass vom Rest isoliert werden soll."));
        JOptionPane.showMessageDialog(null,
                String.format("Benutzer: %s\nDomain: %s\n%d. Level: %s", EmailAnalyse.holeBenutzer(addr),
                        EmailAnalyse.holeDomain(addr), level, EmailAnalyse.holeDomainEbene(addr, level)));
    }
}