package asuender.mergesort;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class TestSorting {

	public static void main(String[] args) {
		List<Long> l1 = new ArrayList<>();

		l1.add(8L);
		l1.add(6L);
		l1.add(7L);
		l1.add(5L);
		l1.add(3L);
		l1.add(0L);
		l1.add(9L);
		System.out.println(l1.toString());
		System.out.println("calling mergesort");
		List<Long> result = MergeSort.mergeSort(l1);
		System.out.println(result.toString());

		List<String> l2 = new LinkedList<String>();
		l2.add("eight");
		l2.add("six");
		l2.add("seven");
		l2.add("five");
		l2.add("three");
		l2.add("four");
		l2.add("nine");
		System.out.println(l2.toString());
		System.out.println("calling mergesort");
		List<String> result2 = MergeSort.mergeSort(l2);
		System.out.println(result2.toString());

	}
}
