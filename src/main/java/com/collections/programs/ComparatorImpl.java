package com.collections.programs;

import java.util.Comparator;
import java.util.TreeSet;

class ComparatorImpl {
	
	public static void main(String args[]) {
		TreeSet<StringBuffer> t = new TreeSet<StringBuffer>(new Mycomparator());
		t.add(new StringBuffer("Rahul"));
		t.add(new StringBuffer("Rohan"));
		t.add(new StringBuffer("Pawan"));
		t.add(new StringBuffer("Murali"));
		t.add(new StringBuffer("Dinesh"));
		System.out.println(t);
	}
}


class Mycomparator implements Comparator<StringBuffer> {

	@Override
	public int compare(StringBuffer o1, StringBuffer o2) {
		String s1=o1.toString();
		String s2= o2.toString();
		return s1.compareTo(s2);
	}
	
}