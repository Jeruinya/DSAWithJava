package com.scaler.dsa.queue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/*
Problem Description
Given an integer, A. Find and Return first positive A integers in ascending order containing only digits 1, 2, and 3.
NOTE: All the A integers will fit in 32-bit integers.

Problem Constraints
1 <= A <= 29500

Input Format
The only argument given is integer A.

Output Format
Return an integer array denoting the first positive A integers in ascending order containing only digits 1, 2 and 3.

Input 1: A = 3
Input 2: A = 7

Output 1: [1, 2, 3]
Output 2: [1, 2, 3, 11, 12, 13, 21]

Explanation 1:
 Output denotes the first 3 integers that contains only digits 1, 2 and 3.

Explanation 2:
 Output denotes the first 3 integers that contains only digits 1, 2 and 3.
 */
public class GenerateKNumbersFrom123 {

	public static void main(String[] args) {
		ArrayList<Integer> list = generateKNumbers(10);
		System.out.println(list);

		System.out.println(solve(10));

	}

	private static ArrayList<Integer> generateKNumbers(int A) {
		ArrayList<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(2);
		list.add(3);
		int i = 0;
		while (list.size() < A) {
			int prefix = list.get(i);
			i++;
			list.add(prefix * 10 + 1);
			list.add(prefix * 10 + 2);
			list.add(prefix * 10 + 3);
		}

		while (list.size() > A)
			list.remove(list.size() - 1);

		return list;
	}

	public static ArrayList<Integer> solve(int A) {
		Queue<Integer> q = new LinkedList<Integer>();
		ArrayList<Integer> ans = new ArrayList<>();
		q.add(1);
		q.add(2);
		q.add(3);
		int cnt = 3;
		while (ans.size() < A) {
			int x = q.peek();
			ans.add(x);
			q.remove();
			if (cnt >= A)
				continue;
			q.add(10 * x + 1);
			q.add(10 * x + 2);
			q.add(10 * x + 3);
			cnt += 3;
		}
		return ans;
	}
}