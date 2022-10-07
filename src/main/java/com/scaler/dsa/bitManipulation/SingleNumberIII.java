package com.scaler.dsa.bitManipulation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Problem Description
Given an array of positive integers A, two integers appear only once, and all the other integers appear twice.
Find the two integers that appear only once.
Note: Return the two numbers in ascending order.
Problem Constraints
2 <= |A| <= 100000
1 <= A[i] <= 109

Input Format
The first argument is an array of integers of size N.

Output Format
Return an array of two integers that appear only once.

Input 1:A = [1, 2, 3, 1, 2, 4]
Input 2:A = [1, 2]

Output 1:[3, 4]
Output 2:[1, 2]

Explanation 1:
3 and 4 appear only once.

Explanation 2:
1 and 2 appear only once.

Approach:
1-- Use Hashmap and store elements with its frequency. now find all the elements which are having frequency as one.

2->Bistmasking:

Take xor of complete array and the will give the xor of a^b  where a and b are the unique elements.
Now the main concern here is how to extract a and b from a^b.

suppose xor=100100
Here in xor we are getting one means either a's or b's bit is different means either in a bit is 1 and in b bit is 0 or vice versa.
so we can say that wherever there is a 1 in the xor value then bit in a and b is not same.

we can divide the array in  two half
1-xra=xor of the values with 1 at 3rd bit 
2-xrb=xor of values that have 0 at 3rd bit

xr & (xr-1)--> same as xr but differ at first high bit

xr=12		xr-1=11
1100 & 1011 = 1000

1000 ^ 1100 = 100

so mask =100
 */
public class SingleNumberIII {

	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(186, 256, 102, 377, 186, 377);

		List<Integer> res = findTwoUniqueNumbers(list);
		System.out.println(res);

	}

	public static List<Integer> findTwoUniqueNumbers(List<Integer> A) {

		int xr = 0;
		int xra = 0;
		int xrb = 0;
		List<Integer> list = new ArrayList<>();

		for (int i = 0; i < A.size(); i++)
			xr = xr ^ A.get(i);

		int mask = ((xr & (xr - 1))) ^ xr;

		for (int i = 0; i < A.size(); i++) {
			if ((A.get(i) & mask) > 0)
				xra = xra ^ A.get(i);
			else
				xrb = xrb ^ A.get(i);
		}

		list.add(Math.min(xra, xrb));
		list.add(Math.max(xra, xrb));

		return list;
	}

	public static int[] solve(int[] A) {
		int aXorb = 0; // the result of a xor b;
		for (int item : A)
			aXorb ^= item;
		int lastBit = (aXorb & (aXorb - 1)) ^ aXorb; // the last bit that a diffs b
		int intA = 0, intB = 0;
		for (int item : A) {
			// based on the last bit, group the items into groupA(include a) and groupB
			if ((item & lastBit) != 0)
				intA = intA ^ item;
			else
				intB = intB ^ item;
		}
		int x = Math.min(intA, intB), y = Math.max(intA, intB);
		int[] ans = new int[2];
		ans[0] = x;
		ans[1] = y;
		return ans;
	}
}
