package com.scaler.dsa.maths;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/*
Problem Description
Given an array of integers A of size N containing GCD of every possible pair of elements of another array.
Find and return the original numbers used to calculate the GCD array in any order. For example, 
if original numbers are {2, 8, 10} then the given array will be {2, 2, 2, 2, 8, 2, 2, 2, 10}.

Problem Constraints
1 <= N <= 10000
1 <= A[i] <= 109
Input Format
The first and only argument given is the integer array A.
Output Format
Find and return the original numbers which are used to calculate the GCD array in any order.

Input 1: A = [2, 2, 2, 2, 8, 2, 2, 2, 10]
Input 2: A = [5, 5, 5, 15]

Output 1: [2, 8, 10]
Output 2: [5, 15]
Explanation 1:
 Initially, array A = [2, 2, 2, 2, 8, 2, 2, 2, 10].
 2 is the gcd between 2 and 8, 2 and 10.
 8 and 10 are the gcds pair with itself.
 Therefore, [2, 8, 10] is the original array.
Explanation 2:

 Initially, array A = [5, 5, 5, 15].
 5 is the gcd between 5 and 15.
 15 is the gcds pair with itself.
 Therefore, [5, 15] is the original array.
 
	2		8		10

2	2		2		2

8   2		8		2

10 2		2		10

Formed matrix and generated all the possible pair GCD
	
	
	

 */
public class AllGCDPair {

	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<>();
		list.add(2);
		list.add(2);
		list.add(2);
		list.add(8);
		list.add(2);
		list.add(2);
		list.add(2);
		list.add(10);
		List<Integer> res = getOriginalArray(list);
		System.out.println(res);
		
		List<Integer> res1 = getOriginalArray1(list);
		System.out.println(res1);
	}

	private static List<Integer> getOriginalArray(List<Integer> A) {

		ArrayList<Integer> res = new ArrayList<Integer>();
		int N = A.size();
		int span = (int) Math.sqrt(N); // Total iterations
		int step = 0; // steps to reach span
		int max = Integer.MIN_VALUE;

		for (int i = 0; i < N; i++) {
			max = Math.max(max, A.get(i));
			step++;

			if (step == span) {
				res.add(max);

				max = Integer.MIN_VALUE;
				step = 0;
			}
		}

		return res;
	}

	public static ArrayList<Integer> getOriginalArray1(ArrayList<Integer> A) {
		ArrayList<Integer> ans = new ArrayList<Integer>();
		Collections.sort(A, Collections.reverseOrder());
		HashMap<Integer, Integer> mp = new HashMap<Integer, Integer>();
		for (int i = 0; i < A.size(); i++) {
			int x = A.get(i);
			if (mp.containsKey(x) && mp.get(x) > 0)
				mp.put(x, mp.get(x) - 1);
			else {
				for (int j = 0; j < ans.size(); j++) {
					int g = gcd(ans.get(j), x);

					if (mp.containsKey(g))
						mp.put(g, mp.get(g) + 2);
					else
						mp.put(g, 2);
				}
				ans.add(x);
			}
		}
		return ans;
	}

	public static int gcd(int A, int B) {
		if (A == 0)
			return B;
		return gcd(B % A, A);
	}
}
