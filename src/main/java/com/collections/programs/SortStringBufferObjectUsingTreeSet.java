package com.collections.programs;

import java.util.Comparator;
import java.util.TreeSet;

public class SortStringBufferObjectUsingTreeSet {

	public static void main(String[] args) {
		TreeSet<StringBuffer> t = new TreeSet<>(new Comp3());//[America, Bishunpur, Gond, Gorakhpur, London, Lucknow, Peris, Ram]
		t.add(new StringBuffer("Ram"));
		t.add(new StringBuffer("Gorakhpur"));
		t.add(new StringBuffer("Gond"));
		t.add(new StringBuffer("Lucknow"));
		t.add(new StringBuffer("America"));
		t.add(new StringBuffer("London"));
		t.add(new StringBuffer("Peris"));
		t.add(new StringBuffer("Bishunpur"));

		System.out.println(t);

	}

}
 
 class Comp3 implements Comparator<StringBuffer> {		
		@Override
		public int compare(StringBuffer I1, StringBuffer I2) {
			String i1=I1.toString();
			String i2=I2.toString();
			return i1.compareTo(i2);
		}

	}