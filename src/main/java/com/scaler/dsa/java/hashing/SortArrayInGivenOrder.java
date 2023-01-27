package com.scaler.dsa.java.hashing;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

/*
Problem Description
Given two arrays of integers A and B, Sort A in such a way that the relative order among the 
elements will be the same as those are in B.
For the elements not present in B, append them at last in sorted order.
Return the array A after sorting from the above method.
NOTE: Elements of B are unique.


Problem Constraints
1 <= length of the array A <= 100000
1 <= length of the array B <= 100000
-10^9 <= A[i] <= 10^9

Input Format
The first argument given is the integer array A.
The second argument given is the integer array B.

Output Format
Return the array A after sorting as described.

Input 1:
A = [1, 2, 3, 4, 5]
B = [5, 4, 2]
Input 2:
A = [5, 17, 100, 11]
B = [1, 100]

Output 1:
[5, 4, 2, 1, 3]
Output 2:
[100, 5, 11, 17]

Explanation 1:
 Simply sort as described.

Explanation 2:
 Simply sort as described.
 */
public class SortArrayInGivenOrder {

	public static void main(String[] args) {
		ArrayList<Integer> list1 = new ArrayList<>();
		list1.add(1);
		list1.add(2);
		list1.add(3);
		list1.add(4);
		list1.add(5);

		ArrayList<Integer> list2 = new ArrayList<>();
		list2.add(5);
		list2.add(4);
		list2.add(2);

		System.out.println(sortOrder(list1, list2));

	}

	public static ArrayList<Integer> sortOrder(ArrayList<Integer> A, ArrayList<Integer> B) {

		Collections.sort(A);

		HashMap<Integer, Integer> hm = new HashMap<>();
		for (int i = 0; i < A.size(); i++) {
			if (hm.containsKey(A.get(i)))
				hm.put(A.get(i), hm.get(A.get(i)) + 1);
			else
				hm.put(A.get(i), 1);
		}

		ArrayList<Integer> ans = new ArrayList<>();

		for (int i = 0; i < B.size(); i++) {
			while (hm.containsKey(B.get(i))) {
				ans.add(B.get(i));

				hm.put(B.get(i), hm.get(B.get(i)) - 1);
				if (hm.get(B.get(i)) == 0)
					hm.remove(B.get(i));
			}
		}

		for (int i = 0; i < A.size(); i++) {
			if (hm.containsKey(A.get(i))) {
				ans.add(A.get(i));
				hm.put(A.get(i), hm.get(A.get(i)) - 1);
				if ((hm.get(A.get(i)) == 0))
					hm.remove(A.get(i));
			}
		}
		return ans;
	}
}