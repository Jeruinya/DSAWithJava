package com.scaler.dsa.twoPointer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

/*
Problem Description
Given an one-dimensional integer array A of size N and an integer B.
Count all distinct pairs with difference equal to B.
Here a pair is defined as an integer pair (x, y), where x and y are both numbers in the array and their 
absolute difference is B.

Problem Constraints
1 <= N <= 104
0 <= A[i], B <= 105

Input Format
First argument is an one-dimensional integer array A of size N.
Second argument is an integer B.
Output Format
Return an integer denoting the count of all distinct pairs with difference equal to B.

Input 1:
 A = [1, 5, 3, 4, 2]
 B = 3
Input 2:
 A = [8, 12, 16, 4, 0, 20]
 B = 4
Input 3:
 A = [1, 1, 1, 2, 2]
 B = 0

Output 1: 2
Output 2: 5
Output 3: 2

Explanation 1:
 There are 2 unique pairs with difference 3, the pairs are {1, 4} and {5, 2} 

Explanation 2:
 There are 5 unique pairs with difference 4, the pairs are {0, 4}, {4, 8}, {8, 12}, {12, 16} and {16, 20} 

Explanation 3:
 There are 2 unique pairs with difference 0, the pairs are {1, 1} and {2, 2}.
 */
public class CountAllPairs3 {

	public static void main(String[] args) {
		int A[] = { 1, 5, 3, 4, 2 };
		int B = 3;
		System.out.println(distinctPairs(A, B));

		ArrayList<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(5);
		list.add(3);
		list.add(4);
		list.add(2);

		System.out.println(distinctPairsEff(list, B));
	}

	public static int distinctPairs(int[] A, int B) {
		int n = A.length;
		int count = 0;
		HashMap<Integer, Integer> hm = new HashMap<>();
		for (int i = 0; i < n; i++) {
			if (hm.containsKey(A[i]))
				hm.put(A[i], hm.get(A[i]) + 1);

			else
				hm.put(A[i], 1);
		}
		for (Integer key : hm.keySet()) {
			if (B == 0) {
				if (hm.get(key) > 1)
					count++;
			} else {
				int keyPair = key + B;
				if (hm.containsKey(keyPair)) {
					if (hm.get(keyPair) >= 1)
						count += 1;
				}
			}
		}

		return count;
	}

	public static int distinctPairsEff(ArrayList<Integer> A, int B) {
		Collections.sort(A);
		int i = 0, j = 1;
		long ans = 0;
		while (j < A.size()) {
			if (j == i) {
				j++;
				continue;
			}
			int x = A.get(i), y = A.get(j);
			if (y - x == B) {
				ans++;
				while (i < A.size() && A.get(i) == x)
					i++;
				while (j < A.size() && A.get(j) == y)
					j++;
			} else if (y - x > B) {
				i++;
			} else
				j++;
		}
		return (int) ans;
	}
}
