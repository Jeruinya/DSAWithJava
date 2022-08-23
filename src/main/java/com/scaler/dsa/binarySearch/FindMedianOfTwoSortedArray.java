package com.scaler.dsa.binarySearch;

/*
Problem Description
There are two sorted arrays A and B of sizes N and M respectively.
Find the median of the two sorted arrays ( The median of the array formed by merging both the arrays ).

NOTE:
The overall run time complexity should be O(log(m+n)).
IF the number of elements in the merged array is even, then the median is the average 
of (n/2)th and (n/2+1)th element. For example, if the array is [1 2 3 4], the median is (2 + 3) / 2.0 = 2.5.

Problem Constraints
1 <= N + M <= 2*106
Input Format
The first argument is an integer array A of size N.
The second argument is an integer array B of size M.
Output Format
Return a decimal value denoting the median of two sorted arrays.

Input 1: A = [1, 4, 5]  B = [2, 3]
Input 2: A = [1, 2, 3]  B = [4]

Output 1: 3.0
Output 2: 2.5

Explanation 1:
 The median of both the sorted arrays will be 3.0.
 
Explanation 2:
 The median of both the sorted arrays will be (2+3)/2 = 2.5.
 */
import java.util.ArrayList;
import java.util.List;

public class FindMedianOfTwoSortedArray {

	public static void main(String[] args) {

		ArrayList<Integer> list = new ArrayList<>();
		ArrayList<Integer> list1 = new ArrayList<>();
		list.add(1);
		list.add(4);
		list.add(5);

		list1.add(2);
		list1.add(3);
		System.out.println(findMedianSortedArrays(list, list1));

	}

	public static double findMedianSortedArrays(final List<Integer> A, final List<Integer> B) {
		int n = A.size();
		int m = B.size();
		ArrayList<Integer> list = new ArrayList<>();

		int i, j;
		int k = 0;
		for (i = 0, j = 0; k < n + m; k++) {
			if (i >= n)
				list.add(B.get(j++));
			else if (j >= m)
				list.add(A.get(i++));
			else if (A.get(i) <= B.get(j))
				list.add(A.get(i++));
			else
				list.add(B.get(j++));
		}

		return getMedian(list);
	}

	public static double getMedian(ArrayList<Integer> list) {
		int n = list.size();
		double res = 0;
		if (n % 2 == 0) {
			int a = n / 2;
			int b = list.get(a);
			int c = list.get(a - 1);
			res = (b + c) / 2.0;
		} else {
			int z = n / 2;
			res = list.get(z);
		}

		return res;
	}
}