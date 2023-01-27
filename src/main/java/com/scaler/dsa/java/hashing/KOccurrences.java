package com.scaler.dsa.java.hashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
/*
Groot has N trees lined up in front of him where the height of the i'th tree is denoted by H[i].
He wants to select some trees to replace his broken branches.
But he wants uniformity in his selection of trees.
So he picks only those trees whose heights have frequency B.
He then sums up the heights that occur B times. (He adds the height only once to the sum and not B times).
But the sum he ended up getting was huge so he prints it modulo 10^9+7.
In case no such cluster exists, Groot becomes sad and prints -1.

Constraints:
1.   1<=N<=100000
2.   1<=B<=N
3.   0<=H[i]<=10^9
Input: Integers N and B and an array C of size N
Output: Sum of all numbers in the array that occur exactly B times.

Input:N=5 ,B=2 ,C=[1 2 2 3 3]
Output:5
Explanation:

There are 3 distinct numbers in the array which are 1,2,3.
Out of these, only 2 and 3 occur twice. Therefore the answer is sum of 2 and 3 which is 5.
 */
public class KOccurrences {

	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(2);
		list.add(2);
		list.add(3);
		list.add(3);
		int B = 2, A = 5;
		System.out.println(getSum(A, B, list));

	}

	public static int getSum(int A, int B, ArrayList<Integer> C) {

		int sum = 0;
		boolean found = false;
		Map<Integer, Integer> hm = new HashMap<>();

		for (int i = 0; i <C.size(); i++) {
			if (hm.containsKey(C.get(i)))
				hm.put(C.get(i), hm.get(C.get(i)) + 1);
			else 
				hm.put(C.get(i), 1);
		}
		for (Map.Entry<Integer, Integer> entry : hm.entrySet()) {
			if (entry.getValue() == B) {
				sum = sum + entry.getKey();
				found = true;
			}
		}

		if (found == false)
			return -1;
		return sum % (10 ^ 9 + 7);
	}
}