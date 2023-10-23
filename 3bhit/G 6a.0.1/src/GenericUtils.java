/**
 * Diese Klasse bietet eine Methode zum Umdrehen eines Arrays an.
 * @author Andreas Suender
 * @version 03-14-2022
 */
public class GenericUtils {
    /**
     * Diese Methode dreht die Elemente des gegebenen Arrays in ihrer Reihenfolge um.
     * Dies passiert "in-place", dies bedeutet, dass kein neues Array erzeugt wird
     * und das gegebene Objekt somit verändert wird.
     * @param array Array, welches umgedreht werden soll
     * @param <T> variabler Typ des Arrays
     */
    public static <T> void umdrehen(T[] array) {
        int size = array.length;
        T tmp;

        for (int i = 0; i < size / 2; i++) {
            tmp = array[i];
            array[i] = array[size - i - 1];
            array[size - i - 1] = tmp;
        }
    }
}
