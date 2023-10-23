package asuender;

/**
 * Diese Klasse testet die MyLinkedQueue sowie den Iterator und alle ihre wichtigen Methoden.
 * @author Andreas Suender
 * @version 05-08-2022
 */
public class Test {
    public static void main(String[] args) {
        MyLinkedQueue<Integer> q = new MyLinkedQueue<>();

        q.append(5);
        q.append(15);
        q.append(20);

        MyIterator<Integer> it = q.iterator();
        while(it.hasNext()) {
            System.out.println(it.next());
        }

        q.delete();

        System.out.println("------------------");

        for (int i : q) {
            System.out.println(i);
        }
    }
}
