package asuender.mergesort;

import java.util.*;

/**
 * Diese Klasse implementiert den MergeSort-Algorithmus.
 * @author Andreas Suender
 * @version 06-01-2022
 */
public class MergeSort {
    /**
     * Diese Methode sortiert eine Liste mittels des MergeSort-Algorithmus.
     * @param list Die zu sortierende Liste.
     * @param <E> Der Typ der Liste.
     * @return Die sortierte Liste.
     */
    public static <E extends Comparable<E>> List<E> mergeSort(List<E> list) {
        int n = list.size();

        if (n == 1) {
            return list;
        }

        List<E> left = new LinkedList<E>(list.subList(0, n / 2));
        List<E> right = new LinkedList<E>(list.subList(n / 2, n));

        return merge(mergeSort(left), mergeSort(right));
    }

    /**
     * Diese Methode mergt zwei Listen mittels des MergeSort-Algorithmus.
     * @param left Die linke Liste.
     * @param right Die rechte Liste.
     * @param <E> Der Typ der Liste.
     * @return Die sortierte und gemergte Liste.
     */
    private static <E extends Comparable<E>> List<E> merge(List<E> left, List<E> right) {
        List<E> result = new ArrayList<>();

        while (!left.isEmpty() && !right.isEmpty()) {
            if (left.get(0).compareTo(right.get(0)) < 0) {
                result.add(left.remove(0));
            } else {
                result.add(right.remove(0));
            }
        }

        while (!left.isEmpty()) {
            result.add(left.remove(0));
        }

        while (!right.isEmpty()) {
            result.add(right.remove(0));
        }

        return result;
    }
}
