/**
 * FehlerBeiKonstanten
 * 
 * Diese Klasse enthält Test-Code zum Experimentieren mit Konstanten. Die auskommentierten
 * Zeilen sind fehlerhaft.
 * 
 * @author Andreas Suender
 * @version 2020-06-16
 */
public class FehlerBeiKonstanten {

    public static void main(String[] args) {
        final int ERSTE_KONSTANTE = 5;
        // ERSTE_KONSTANTE = 3;

        final int ZWEITE_KONSTANTE;
        ZWEITE_KONSTANTE = 7;
        // ZWEITE_KONSTANTE = 8;

        final int CONST_SUMME = ERSTE_KONSTANTE + ZWEITE_KONSTANTE;
        System.out.println("Wert der Summe: " + CONST_SUMME);
    }
}