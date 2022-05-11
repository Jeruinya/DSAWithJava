package com.collections.programs;

import java.util.Comparator;
import java.util.TreeSet;

public class SortStringObjectsInReverseOrderOfAlphabets {

	public static void main(String[] args) {
		
		//TreeSet<String> t = new TreeSet<>(new Comp1());//[Ram, Peris, Lucknow, London, Gorakhpur, Gond, Bishunpur, America]

		TreeSet<String> t = new TreeSet<>(new Comp2());//[Ram, Gond, Peris, London, Lucknow, Gorakhpur]
		t.add("Ram");
		t.add("Gorakhpur");
		t.add("Gond");
		t.add("Lucknow");
		t.add("America");
		t.add("London");
		t.add("Peris");
		t.add("Bishunpur");

		System.out.println(t);

	}

}
 
/*
 * class Comp1 implements Comparator<String> {
 * 
 * @Override public int compare(String I1, String I2) { return I2.compareTo(I1);
 * }
 * 
 * }
 */
 
 class Comp2 implements Comparator<String> {		
		@Override
		public int compare(String I1, String I2) {
			Integer i1=I1.length();
			Integer i2=I2.length();
			return i1.compareTo(i2);
		}

	}