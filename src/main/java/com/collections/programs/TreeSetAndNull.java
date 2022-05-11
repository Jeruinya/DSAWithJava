package com.collections.programs;
/*
In TreeSet null insertion is not possible otherwise will get NPE
 */
import java.util.TreeSet;

public class TreeSetAndNull {

	public static void main(String[] args) {
		TreeSet t = new TreeSet<>();
		t.add(null);
		System.out.println(t);
	}
}
