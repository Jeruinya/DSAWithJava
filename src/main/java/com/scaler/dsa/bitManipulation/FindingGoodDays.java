package com.scaler.dsa.bitManipulation;

/*
Problem Description
Alex has a cat named Boomer. He decides to put his cat to the test for eternity.
He starts on day 1 with a stash of food unit, every next day, the stash doubles.
If Boomer is well behaved during a particular day, she receives food worth equal to the stash on that day.
Boomer receives a net worth of A units of food. What is the number of days he was well behaved?
Problem Constraints
1 <= A <= 231-1
Input Format
First and only argument is an integer A.
Output Format
Return an integer denoting the number of days Boomer was well behaved.

Input 1:A = 5
Input 2:A = 8
Output 1: 2
Output 2: 1
Explanation 1:
 To eat a total of 5 units of food, Boomer behaved normally on Day 1 and on the Day 3.
Explanation 2:
 To eat a total of 8 units of food, Boomer behaved normally only on day 4.
 
Approach: 
Since for each day, the food doubles up as the previous day with 1 unit on the first day, starting from i = 0,
the number of food units Boomer was supposed to get on ith day is 2i.

Only on the days he was well behaved did he get food. So adding the power of 2 on each day, he was well behaved,
gives the total number of food units, i.e., A.

Hence, the number of 1�s in the binary representation of A is the number of days he was well behaved.
 */

public class FindingGoodDays {

	public static void main(String[] args) {
		System.out.println(solve(89));

	}

	public static int solve(int A) {
		int count = 0;
		while (A > 0) {
			if ((A & 1) == 1)
				count++;
			A = A >> 1;
		}
		return count;
	}

}
