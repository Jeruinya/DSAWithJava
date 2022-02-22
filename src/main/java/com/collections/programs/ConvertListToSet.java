package com.collections.programs;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.OptionalInt;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ConvertListToSet {

	public static <T> Set<T> convertListToSet(List<T> list) {
		// create a set from the List
		return new HashSet<>(list);
	}

	public static void main(String args[]) {

		// Create a stream of integers
		List<String> list = Arrays.asList("GeeksForGeeks", "Geeks", "forGeeks", "A computer portal", "for", "Geeks");
		// Print the List
		System.out.println("List: " + list);

		// Convert List to stream
		Set<String> set = convertListToSet(list);
		System.out.println("Set from List: " + set);

		// Creating a list of strings
		List<String> aList = Arrays.asList("Geeks", "for", "GeeksQuiz", "GeeksforGeeks", "GFG");

		Set<String> hSet = new HashSet<String>();
		for (String x : aList)
			hSet.add(x);

		System.out.println("Created HashSet is");
		for (String x : hSet)
			System.out.println(x);

		// Creating a hash set using constructor
		Set<String> hSet1 = new HashSet<String>(aList);

		System.out.println("Created HashSet is");
		for (String x : hSet1)
			System.out.println(x);

		// Converting to set using stream
		List<Integer> l = Arrays.asList(1, 2, 3, 4, 5, 4, 4, 5, 6, 1, 2, 3);
		Set<Integer> newSet = l.stream().collect(Collectors.toSet());
		System.out.println(newSet);
		
		//Deutche Bank what willbe output of below program?
		OptionalInt max=IntStream.range(1, 20).filter(v->v%4==0).filter(v->v<10).max();
		System.out.println("---------"+max);//8
		
		
		//Deutsche bank what will be the output of belowprogram
		Map<Integer,Object> sampleMap=new TreeMap<Integer,Object>();
		sampleMap.put(1, null);
		sampleMap.put(5, null);
		sampleMap.put(3, null);
		sampleMap.put(2, null);
		sampleMap.put(4, null);
		System.out.println("SampleMap-------"+sampleMap);
		
		//Deutsche bank what will be the output of belowprogram
		List<String> streamGenerated=Stream.generate( ()-> "DBOI").limit(10).collect(Collectors.toList());
		System.out.println("stream Generated:"+streamGenerated);
		
		//Deutsche bank what will be the output of belowprogram
		List<List<Integer>> listOfList=Arrays.asList(Arrays.asList(1,2),Arrays.asList(5,6));
		List<Integer> listOut=listOfList.stream().flatMap(x->x.stream()).collect(Collectors.toList());
		System.out.println("FlatMap:"+listOut);
		
		System.out.println("Hello");
		//Deutsche bank what will be the output of belowprogram
		System.out.println("---------"+IntStream.range(1, 5).reduce(2,(a,b)->a+b));
	}
}