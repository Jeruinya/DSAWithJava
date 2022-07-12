package com.collections.programs;

import java.util.HashSet;
import java.util.Set;

public class HashSetAndNull {

	public static void main(String[] args) {
		Set<String> set= new HashSet<>();
		set.add(null);
		set.add(null);
		set.add(null);
		set.add(null);
		System.out.println(set); //duplicates are not allowed so there will be only one null
		

	}

}
