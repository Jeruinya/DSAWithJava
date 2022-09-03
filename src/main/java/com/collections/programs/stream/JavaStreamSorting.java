package com.collections.programs.stream;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class JavaStreamSorting {

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		list.add(12);
		list.add(3);
		list.add(14);
		list.add(44);
		list.add(22);
		list.add(78);

		// Natural ascending sorting order
		List<Integer> res = list.parallelStream().sorted().collect(Collectors.toList());
		System.out.println(list);
		System.out.println(res);

		// Natural descending sorting order
		List<Integer> rev = list.parallelStream().sorted((i1, i2) -> -i1.compareTo(i2)).collect(Collectors.toList());
		System.out.println(rev);
		List<Integer> rev1 = list.stream().sorted(Collections.reverseOrder()).collect(Collectors.toList());
		System.out.println(rev1);

		// Find minimum element from list
		int min = list.parallelStream().min((i1, i2) -> i1.compareTo(i2)).get();
		System.out.println(min);

		// Find minimum element from list
		Integer max = list.parallelStream().min((i1, i2) -> -i1.compareTo(i2)).get();
		System.out.println(max);

		// Find minimum element from list
		Integer max1 = list.parallelStream().max((i1, i2) -> i1.compareTo(i2)).get();
		System.out.println(max1);
	}

}
