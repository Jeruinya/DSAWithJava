package com.scaler.dsa.arrays;

/*
Problem Description
There are A beggars sitting in a row outside a temple. Each beggar initially has an empty pot. 
When the devotees come to the temple, they donate some amount of coins to these beggars. 
Each devotee gives a fixed amount of coin(according to their faith and ability) to some K beggars 
sitting next to each other.

Given the amount P donated by each devotee to the beggars ranging from L to R index, 
where 1 <= L <= R <= A, find out the final amount of money in each beggar's pot at the end of the day, 
provided they don't fill their pots by any other means.
For ith devotee B[i][0] = L, B[i][1] = R, B[i][2] = P, Given by the 2D array B


Problem Constraints
1 <= A <= 2 * 105
1 <= L <= R <= A
1 <= P <= 103
0 <= len(B) <= 105

Input Format
The first argument is a single integer A.
The second argument is a 2D integer array B.

Output Format
Return an array(0 based indexing) that stores the total number of coins in each beggars pot.

Input 1:-A = 5 B = [[1, 2, 10], [2, 3, 20], [2, 5, 25]]

Output 1:-10 55 45 25 25

Explanation 1:-
First devotee donated 10 coins to beggars ranging from 1 to 2. Final amount in each beggars pot after first devotee: [10, 10, 0, 0, 0]
Second devotee donated 20 coins to beggars ranging from 2 to 3. Final amount in each beggars pot after second devotee: [10, 30, 20, 0, 0]
Third devotee donated 25 coins to beggars ranging from 2 to 5. Final amount in each beggars pot after third devotee: [10, 55, 45, 25, 25]

Approach:
Brute force-Iterate over given array B and find left index and right index and add p value from left index to right index in array.

Time complexity: length of B * length of longest index.

Efficient Approach:
calculate left index and right index and assign value to left index and subtract value to right index+1

A=5
B=1	2	10
  2 3	20
  2	5	25
  
		1	2	 3		4	5	
		0	0	 0		0	0
		10	0   -10  	0	0
		10	20  -10   -20   0
		10	45	-10   -20   0	
		
Now calculate the pre-sum

10	55	45	25	25
 */
import java.util.Arrays;

public class BeggarsOutsideTemple {

	public static void main(String[] args) {
		int A = 5;
		int B[][] = { { 1, 2, 10 }, { 2, 3, 20 }, { 2, 5, 25 } };

		int[] res = solveNaive(A, B);
		System.out.println(Arrays.toString(res));

		int[] res1 = solveEfficient(A, B);
		System.out.println(Arrays.toString(res1));

	}

	public static int[] solveNaive(int A, int[][] B) {
		int res[] = new int[A];

		for (int i = 0; i < B.length; i++)
			for (int j = B[i][0] - 1; j < B[i][1]; j++)
				res[j] = res[j] + B[i][2];

		return res;
	}

	public static int[] solveEfficient(int A, int[][] B) {
		int[] coins = new int[A];

		for (int i = 0; i < B.length; i++) {
			int leftIndex = B[i][0] - 1, rightIndex = B[i][1] - 1;
			int p = B[i][2];
			coins[leftIndex] += p;
			if ((rightIndex + 1) < A)
				coins[rightIndex + 1] -= p;
		}
		for (int i = 1; i < A; i++)
			coins[i] = coins[i] + coins[i - 1];
		return coins;
	}
}
