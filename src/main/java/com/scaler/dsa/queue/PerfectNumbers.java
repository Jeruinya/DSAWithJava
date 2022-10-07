package com.scaler.dsa.queue;

import java.util.LinkedList;
import java.util.Queue;

/*
Problem Description
Given an integer A, you have to find the Ath Perfect Number.
A Perfect Number has the following properties:
It comprises only 1 and 2.
The number of digits in a Perfect number is even.
It is a palindrome number.
For example, 11, 22, 112211 are Perfect numbers, where 123, 121, 782, 1 are not.

Problem Constraints
1 <= A <= 100000

Input Format
The only argument given is an integer A.

Output Format
Return a string that denotes the Ath Perfect Number.

Input 1: A = 2
Input 2: A = 3

Output 1: 22
Output 2: 1111

Explanation 1:
First four perfect numbers are:
1. 11
2. 22
3. 1111
4. 1221

Explanation 2:
First four perfect numbers are:
1. 11
2. 22
3. 1111
4. 1221


perfect number series:
11 22 1111 1221 2112 2222........

Number= 1221
a=12
a'=12
a' is the reverse of second part
aa'=1212

a<b
then also aa'<bb'
a=13 a'= 31  aa'=1331
b=15 b'=51   bb'=1551

11 22 1111 1221 2112 2222........

1   2	11	12	21	22........

1 append with 1 is 11
1 append with 2 is 12 
2 append with 1 is 21
2 append with 2 is 22  and so on..

 */
public class PerfectNumbers {

	public static void main(String[] args) {
		int A = 3;
		System.out.println(AthPerfectNumber(A));
		System.out.println(AthPerfectNumberEasy(A));

	}

	private static String AthPerfectNumber(int A) {
		Queue<String> q = new LinkedList<String>();
		if (A == 1)
			return "11";
		else if (A == 2)
			return "22";

		q.add("1");
		q.add("2");
		int cur = 2;
		String ans = new String();
		while (q.size() < A) {
			StringBuilder sb = new StringBuilder(q.peek());
			q.remove();
			sb.append("1");
			q.add(sb.toString());
			cur++;
			if (cur == A)
				ans = sb.toString();
			sb.deleteCharAt(sb.length() - 1);
			sb.append("2");
			cur++;
			if (cur == A)
				ans = sb.toString();
			q.add(sb.toString());
		}
		StringBuilder sb = new StringBuilder(ans);
		return ans + sb.reverse().toString();
	}

	public static String AthPerfectNumberEasy(int A) {
		Queue<String> q = new LinkedList<>();

		q.add("11");
		q.add("22");

		while (A - 1 != 0) {
			String var = q.peek();
			int size = var.length();
			String s1 = var.substring(0, size / 2);
			String s2 = var.substring(size / 2, size);

			q.add(s1 + "11" + s2);
			q.add(s1 + "22" + s2);

			q.remove();
			A--;

		}

		return q.peek();
	}
}
