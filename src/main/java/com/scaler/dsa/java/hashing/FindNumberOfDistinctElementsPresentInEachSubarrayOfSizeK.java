package com.scaler.dsa.java.hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
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
		int res[]=dNumsNaive(A,k);
		System.out.println(Arrays.toString(res));

		ArrayList<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(2);
		list.add(1);
		list.add(3);
		list.add(4);
		list.add(3);
		int B = 3;
		ArrayList<Integer> res1 = dNumsEff(list, B);
		System.out.println(res1);

	}

	public static ArrayList<Integer> dNumsEff(ArrayList<Integer> A, int k) {
		ArrayList<Integer> l = new ArrayList<>();
		Map<Integer, Integer> hm = new HashMap<>();
		int s = 0, e = k - 1;
		for (int i = 0; i < k; i++) {
			if (hm.containsKey(A.get(i)))
				hm.put(A.get(i), hm.get(A.get(i)) + 1);
			else
				hm.put(A.get(i), 1);
		}
		s = 1;
		e = k;
		l.add(hm.size());

		while (e < A.size()) {
			hm.put(A.get(s - 1), hm.get(A.get(s - 1)) - 1);

			if (hm.get(A.get(s - 1)) == 0)
				hm.remove(A.get(s - 1));

			if (hm.containsKey(A.get(e)))
				hm.put(A.get(e), hm.get(A.get(e)) + 1);
			else
				hm.put(A.get(e), 1);
			l.add(hm.size());
			s++;
			e++;
		}
		return l;

	}

	// O(N^2) and O(N)
	public static int[] dNumsNaive(int[] A, int B) {
		int n = A.length;
		int ans[] = new int[n - B + 1];

		for (int i = 0; i < (n - B + 1); i++) {
			HashSet<Integer> hs = new HashSet<>();
			for (int j = i; j < i + B; j++)
				hs.add(A[j]);
			ans[i] = hs.size();

		}
		return ans;
	}

}
