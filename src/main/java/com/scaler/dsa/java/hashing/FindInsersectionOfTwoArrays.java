package com.scaler.dsa.java.hashing;

import java.util.Arrays;
import java.util.HashSet;

public class FindInsersectionOfTwoArrays {

	public static void main(String[] args) {
		int A[] = { 2, 1, 4, 10 };
		int B[] = { 3, 6, 2, 10, 10 };
		int m = A.length;
		int n = B.length;
		HashSet<Integer> s1 = new HashSet<>();
		HashSet<Integer> s2 = new HashSet<>();
		
		for (int i = 0; i < m; i++)
			s1.add(A[i]);
		for (int i = 0; i < n; i++)
			s2.add(B[i]);
		
		s1.retainAll(s2);
		
		int arr[]= new int[s1.size()];
		
		arr=s1.stream().filter(t->t!=null).mapToInt(t-> t).toArray();

		System.out.println(Arrays.toString(arr));
	}
}
