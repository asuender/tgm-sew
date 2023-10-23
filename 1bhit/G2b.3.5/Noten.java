/**
 * Noten
 * 
 * Diese Klasse enthält eine Methode, die zu einer Schulnote die entsprechende ampelfarbe
 * ausgibt.
 * @author Andreas Suender
 * @version 2020-05-07
 */
public class Noten {
    /**
     * Diese Methode übernimmt eine ganzzahlige Schulnote (1-5) und gibt bei 1-3 "Grün", bei
     * 4 "Gelb" und bei 5 "Rot" zurück. 
     * @param grade Schulnote
     * @return Ampelfarbe
     */
    public static String ampelfarbe(int grade) {
        String color = "";
        switch (grade) {
            case 1:
            case 2:
            case 3:
                color="Grün";
                break;
            case 4:
                color="Gelb";
                break;
            case 5:
                color="Rot";
                break;
            default:
                break;
        }
        return color;
    }
}