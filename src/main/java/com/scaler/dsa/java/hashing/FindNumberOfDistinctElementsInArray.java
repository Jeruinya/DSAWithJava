package com.scaler.dsa.java.hashing;

/*
Given N array elements , find number of distinct elements in the array.
 */
import java.util.HashSet;

public class FindNumberOfDistinctElementsInArray {

	public static void main(String[] args) {
		int A[] = { 10, 5, 3, 4, 3, 5, 6 };
		HashSet<Integer> hs = new HashSet<>();
		for (int i = 0; i < A.length; i++)
			hs.add(A[i]); 
		 
		System.out.println(hs.size());
	}
}
