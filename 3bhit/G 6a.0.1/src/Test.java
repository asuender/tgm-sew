import java.util.Arrays;

/**
 * Diese Klasse testet die Methode {@link GenericUtils#umdrehen(Object[])}.
 * @author Andreas Suender
 * @version 03-14-2022
 */
public class Test {
    public static void main(String[] args) {
        Integer[] intArray = new Integer[]{1, 2, 3, 4, 5, 6, 7};
        String[] strArray = new String[]{"umgedreht", "bin", "Ich"};

        GenericUtils.umdrehen(intArray);
        GenericUtils.umdrehen(strArray);

        System.out.println(Arrays.toString(intArray));
        System.out.println(Arrays.toString(strArray));
    }
}
