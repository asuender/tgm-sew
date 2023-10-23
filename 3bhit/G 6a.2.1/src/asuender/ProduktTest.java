package asuender;

import java.util.Iterator;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * @author Andreas Suender
 * @version 05-08-2022
 */
public class ProduktTest {
    public static void main(String[] args) {
        SortedSet<Produkt> set = new TreeSet<>();

        Produkt p1 = new Produkt(11, "Bezeichnung", "Beschreibung", 20.0);
        Produkt p2 = new Produkt(11, "Bezeichnung", "Beschreibung", 20.0);
        Produkt p3 = new Produkt(11, "Bezeichnung", "Beschreibung", 5.0);

        // p2 sollte aufgrund der Gleichheit mit p1 nicht hinzugefügt werden
        set.add(p1);
        set.add(p2);
        System.out.println(set);

        // p3 ist größer als p1, deswegen wird es am Anfang eingefügt
        set.add(p3);
        System.out.println(set);

        // Ausgabe mittels Iterator
        System.out.println("Ausgabe mittels Iterator");
        Iterator<Produkt> it = set.iterator();
        while(it.hasNext()) {
            System.out.println(it.next());
        }
    }
}
