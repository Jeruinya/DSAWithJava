package com.collections.programs;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

public class HashMapAndNull {

	public static void main(String[] args) {
		Map<String,Integer> hm= new HashMap<>();
		hm.put(null,null);
		hm.put(null,123);
		
		Hashtable<String,Integer> ht= new Hashtable<>();
		//ht.put(null, null); //Hashtable does not allow null as key
		System.out.println(ht);
	
		System.out.println(hm); //duplicates are not allowed so there will be only one null
		

	}

}
