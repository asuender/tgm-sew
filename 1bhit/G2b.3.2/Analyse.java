import javax.swing.JOptionPane;

/**
 * Der Benutzer gibt ein gültiges Datum ein und erhält eine getrennte Ausgabe
 * von Tag, Monat und Jahr. Zusätzlich wird der Wochentag ausgegeben.
 * 
 * @author Andreas Suender
 * @version 2020-04-30
 */
public class Analyse {
    /**
     * Der Benutzer gibt ein gültiges Datum ein und erhält eine getrennte Ausgabe
     * von Tag, Monat und Jahr. Zusätzlich wird der Wochentag ausgegeben.
     * 
     * @param args not used
     */
    public static void main(String[] args) {
        // Eingabe
        String date = JOptionPane.showInputDialog(null, "Bitte ein gültiges Datum im Format 't.m.jjjj' eingeben:");

        // hier müssen Tag, Monat und Jahr selbst herausgenommen werden
        String day = "", month = "", year = "";
        int tmp = 0, tmp_index = -1;

        // Selbst entworfen zum Aufsplitten des Datum-Strings
        for (int i = 0; i < date.length(); i++) {
            if (date.charAt(i) == '.') {
                for (int j = tmp_index+1; j < i; j++) {
                    switch (tmp) {
                        case 0:
                            day += date.charAt(j);
                            break;
                        case 1:
                            month += date.charAt(j);
                            break;
                    }
                }
                ++tmp;
                tmp_index = i;
            }
            else if (tmp==2) {
                for (int j=i; j<date.length(); j++)
                    year+=date.charAt(j);
                break;
            }
        }

        // Formatierte Ausgabe
        JOptionPane.showMessageDialog(null,
                "Tag: " + Datum.tag(date) + "\n" + "Monat: " + Datum.monat(date) + "\n" + "Jahr: " + Datum.jahr(date)
                        + "\n" + "Wochentag: "
                        + Datum.wochentag(Integer.parseInt(day), Integer.parseInt(month), Integer.parseInt(year)));
    }
}