package com.scaler.dsa.java.hashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

/*
Given N array elements, calculate number of distinct elements in every subarray of size k.
A={2,4,3,8,3,9,4,9,4,10} k=4.
s	e		
0	4		{2,4,3,8}  
1	5		{ * 4,3,8,3}   removing one element from starting and add one element at end of the subarray
2	6		{ 	 *3,8,3,9}
3	7		{	  * 8,3,9,4}

for each subarray use hash map to count number of distinct elements. because has set will not give the proper result. 
below Hashset is used but this is giving O(N^2) solution and to get O(N) solution we can not use Hash set because when we will
remove the element from starting and add element at end then Hash set will fail to give proper response.
 */
public class FindNumberOfDistinctElementsPresentInEachSubarrayOfSizeK {

	public static void main(String[] args) {
		int A[] = { 2, 4, 3, 8, 3, 9, 4, 9, 4, 10 }, k = 4;
		List<Integer> l = findNumberOfDistinctElementsInSubarrayNaive(A, k);
		System.out.println(l);

		List<Integer> l1 = findNumberOfDistinctElementsInSubarrayEfficient(A, k);
		System.out.println(l1);

	}

	private static List<Integer> findNumberOfDistinctElementsInSubarrayEfficient(int[] A, int k) {

		List<Integer> l = new ArrayList<>();
		Map<Integer, Integer> hm = new HashMap<>();
		int s = 0, e = k - 1;
		for (int i = 0; i < k; i++) {
			if (hm.containsKey(A[i]))
				hm.put(A[i], hm.get(A[i]) + 1);
			else
				hm.put(A[i], 1);
		}
		s = 1;
		e = k;
		l.add(hm.size());

		while (e < A.length) {
			hm.put(A[s - 1], hm.get(A[s - 1]) - 1);

			if ((hm.get(A[s - 1]) == 0))
				hm.remove(A[s - 1]);

			if (hm.containsKey(A[e]))
				hm.put(A[e], hm.get(A[e]) + 1);
			else
				hm.put(A[e], 1);
			l.add(hm.size());
			s++;
			e++;
		}
		return l;
	}

	// O(N^2) and O(N)
	private static List<Integer> findNumberOfDistinctElementsInSubarrayNaive(int[] A, int k) {
		ArrayList<Integer> l = new ArrayList<>();
		int n = A.length;
		int s = 0, e = k - 1;
		while (e < n) {
			HashSet<Integer> hs = new HashSet<>();
			for (int i = s; i <= e; i++)
				hs.add(A[i]);
			l.add(hs.size());
			s++;
			e++;
		}
		return l;
	}

}
