package com.scaler.dsa.java.hashing;

import java.security.KeyStore.Entry;
import java.util.HashMap;

/*
Given an array, count the number of duplicate pairs, ie A[i]=A[j] such that i!=j.
 */
public class CountDuplicatePairs {

	public static void main(String[] args) {
		int A[] = { 1, 3, 4, 1, 5, 1, 4 };
		System.out.println(countDuplicatePairsNaive(A));
		
		System.out.println(countDuplicatePairsEff(A));

	}

	private static int countDuplicatePairsEff(int[] A) {
		HashMap<Integer,Integer> hm= new HashMap<>();
		int ans=0;
		for(int i=0;i<A.length;i++) {
			if(hm.containsKey(A[i]))
				hm.put(A[i], hm.get(A[i])+1);
			else
				hm.put(A[i], 1);
		}
		
		for(int key:hm.keySet()) {
			if(hm.get(key)>=2) {
				int f=hm.get(key);
				ans=ans+(f*(f-1))/2;
			}
		}
		return ans;
	}

	private static int countDuplicatePairsNaive(int[] A) {
		int count = 0;
		for (int i = 0; i < A.length - 1; i++)
			for (int j = i + 1; j < A.length; j++)
				if (A[i] == A[j])
					count++;
		return count;
	}

}
