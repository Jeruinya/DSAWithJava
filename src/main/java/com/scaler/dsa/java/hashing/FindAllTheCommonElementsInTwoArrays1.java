package com.scaler.dsa.java.hashing;

import java.util.ArrayList;
import java.util.HashSet;

public class FindAllTheCommonElementsInTwoArrays1 {

	public static void main(String[] args) {
		ArrayList<Integer> list1 = new ArrayList<>();
		list1.add(1);
		list1.add(2);
		list1.add(2);
		list1.add(1);

		ArrayList<Integer> list2 = new ArrayList<>();
		list2.add(2);
		list2.add(3);
		list2.add(1);
		list2.add(2);
		System.out.println(solve(list1, list2));
	}

	private static HashSet<Integer> solve(ArrayList<Integer> list1, ArrayList<Integer> list2) {
		HashSet<Integer> s1 = new HashSet<>();
		HashSet<Integer> s2 = new HashSet<>();

		for (int i = 0; i < list1.size(); i++)
			s1.add(list1.get(i));
		for (int i = 0; i < list2.size(); i++)
			s2.add(list2.get(i));

		s1.retainAll(s2);
		return s1;

	}
}
