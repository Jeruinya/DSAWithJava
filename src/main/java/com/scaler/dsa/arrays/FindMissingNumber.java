package com.scaler.dsa.arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

/*
Given a list of numbers containing every number from 1 to N. except one number which is missing. 
find the missing number.
Numbers are unordered and no duplicates there.
 */
public class FindMissingNumber {

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(2);
		list.add(4);
		list.add(5);
		int res1 = findMissingNumberSort(list);
		System.out.println(res1);

		int res2 = findMissingNumberHashSet(list);
		System.out.println(res2);

		int res3 = findMissingNumberEfficient(list);
		System.out.println(res3);

	}

	// TC-O(N)
	private static int findMissingNumberEfficient(List<Integer> list) {
		int n = list.size() + 1;
		int numSum = n * (n + 1) / 2;
		int sum = 0;
		for (int x : list)
			sum = sum + x;
		return numSum - sum;
	}

	// TC-O(N) SC-O(N)
	private static int findMissingNumberHashSet(List<Integer> list) {
		HashSet<Integer> hs = new HashSet<>();
		for (int x : list)
			hs.add(x);
		for (int i = 0; i < list.size(); i++) {
			if (!hs.contains(i + 1))
				return i + 1;
		}

		return list.size() + 1;
	}

	// TC-O(nlogn)
	private static int findMissingNumberSort(List<Integer> list) {
		Collections.sort(list);
		for (int i = 0; i < list.size(); i++) {
			if (i + 1 != list.get(i))
				return i + 1;
		}
		return list.size() + 1;
	}

}
