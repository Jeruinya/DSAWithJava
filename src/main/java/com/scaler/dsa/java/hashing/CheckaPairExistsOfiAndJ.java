package com.scaler.dsa.java.hashing;

import java.util.HashMap;
import java.util.HashSet;

/*
Given N array elements , check if there exists a pair (i,j)  such that a[i]+a[j]=k && i!=j.
A=[8,9,1,-2,4,5,11,-6,7,5]  k=22.
a+b= k==> b=k-a. This intuition we have to use to get the answer.
HashSet=[8,9,1,-2,4,5,-6,7]
a		b(k-a)
8		14
9		13
1		21
-2		24
4		18
5		17
11		11-------> here it is matching but index of i and j is same and that we dont needs to take 
So HashSet can not be used we have to maintain the frequency and for that we need HashMap
 */
public class CheckaPairExistsOfiAndJ {

	public static void main(String[] args) {
		int A[] = { 8, 9, 1, -2, 4, 5, 11, -6, 7, 5 };
		int k = 22;

		System.out.println( checkPairExitsNaive(A, k));
		System.out.println(checkPairExitsEfficient(A, k));
		System.out.println(checkPairExitsEfficientButNotWork(A, k));
		
		int A1[] = {1, 5, 4, 1, 2 };
		int k1 = 0;
		System.out.println(checkPairExitsEfficientAMinusB(A1,k1));

	}

	private static boolean checkPairExitsNaive(int[] A, int k) {
		for (int i = 0; i < A.length; i++)
			for (int j = i+1; j < A.length; j++)
				if (A[i] + A[j] == k)
					return true;
		return false;
	}
	//check a+b=k
	private static boolean checkPairExitsEfficient(int[] A, int k) {
		HashMap<Integer, Integer> hm = new HashMap<>();
		for (int i = 0; i < A.length; i++) {
			if (hm.containsKey(A[i]))
				hm.put(A[i], hm.get(A[i]) + 1);
			else
				hm.put(A[i], 1);
		}
		for (int i = 0; i < A.length; i++) {
			int a = A[i], b = k - a;

			if (a == b) {
				if (hm.get(A[i]) > 1)
					return true;
			} else {
				if (hm.containsKey(b))
					return true;
			}
		}
		return false;
	}
	
	//check a-b=k
		private static boolean checkPairExitsEfficientAMinusB(int[] A, int k) {
			HashMap<Integer, Integer> hm = new HashMap<>();
			for (int i = 0; i < A.length; i++) {
				if (hm.containsKey(A[i]))
					hm.put(A[i], hm.get(A[i]) + 1);
				else
					hm.put(A[i], 1);
			}
			for (int i = 0; i < A.length; i++) {
				int a = A[i], b = a-k;

				if (a == b) {
					if (hm.get(A[i]) > 1)
						return true;
				} else {
					if (hm.containsKey(b))
						return true;
				}
			}
			return false;
		}

	//Here this method call is giving result as true which is not correct as i!=j which is given in the condition.
	private static boolean checkPairExitsEfficientButNotWork(int[] A, int k) {
		HashSet<Integer> hs = new HashSet<>();
		for (int i = 0; i < A.length; i++)
			hs.add(A[i]);

		for (int i = 0; i < A.length; i++) {
			int a = A[i], b = k - a;
			if (hs.contains(b))
				return true;
		}
		return false;
	}

}
