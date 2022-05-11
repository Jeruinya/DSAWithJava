package com.collections.programs;

import java.util.Comparator;
import java.util.TreeSet;
 class TreeSetAndComparatorTest {

	public static void main(String[] args) {

		TreeSet<Integer> t = new TreeSet<>(new Comp());
		t.add(10);
		t.add(12);
		t.add(1);
		t.add(4);
		t.add(5);
		t.add(3);
		t.add(90);
		t.add(100);

		System.out.println(t);

	}

}
 
 class Comp implements Comparator<Integer> {		
		@Override
		public int compare(Integer o1, Integer o2) {
			return 1;//Maintain the insertion order [10, 12, 1, 4, 5, 3, 90, 100]
		}

	}