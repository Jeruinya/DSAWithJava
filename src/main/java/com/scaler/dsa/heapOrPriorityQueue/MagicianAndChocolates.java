package com.scaler.dsa.heapOrPriorityQueue;

import java.util.Comparator;
import java.util.PriorityQueue;

/*
Problem Description
Given N bags, each bag contains Bi chocolates. There is a kid and a magician.
In a unit of time, the kid can choose any bag i, and eat Bi chocolates from it, then the magician will fill the 
ith bag with floor(Bi/2) chocolates.
Find the maximum number of chocolates that the kid can eat in A units of time.

NOTE:
floor() function returns the largest integer less than or equal to a given number.
Return your answer modulo 109+7

Problem Constraints
1 <= N <= 100000
0 <= B[i] <= INT_MAX
0 <= A <= 105

Input Format
The first argument is an integer A.
The second argument is an integer array B of size N.

Output Format
Return an integer denoting the maximum number of chocolates the kid can eat in A units of time.

Input 1:
 A = 3
 B = [6, 5]
Input 2:
 A = 5
 b = [2, 4, 6, 8, 10]


Output 1: 14
Output 2: 33

Explanation 1:
 At t = 1 kid eats 6 chocolates from bag 0, and the bag gets filled by 3 chocolates. 
 At t = 2 kid eats 5 chocolates from bag 1, and the bag gets filled by 2 chocolates. 
 At t = 3 kid eats 3 chocolates from bag 0, and the bag gets filled by 1 chocolate. 
 so, total number of chocolates eaten are 6 + 5 + 3 = 14

Explanation 2:
 Maximum number of chocolates that can be eaten is 33
 
Approach: 
1-We can not use the sorted array to solve this problem because suppose the kid picked the largest element from the sorted array
  and which is at the fist position and after that we have to push back the floor value of B[i]/2 , but where to add this value
  is the issue here.
Example: A[]={8,6,1,2}  B=3
sum=8+4+2			Sorted A=[8,6,2,1]

Sorted A=[4,6,2,1]
Sorted A=[2,6,2,1]
Sorted A=[1,6,2,1]

sum= 14 which is incorrect

-> We have to use here max heap.
Greedily at any moment of time the kid will always choose the bag with maximum number of chocolate.

1- Create a max heap containing all the elements of B.
2-Get bag with maximum number of chocolate from the max heap and feed it to the kid.
3-push floor of B[i]/2 back to the max heap.

 */
public class MagicianAndChocolates {

	public static void main(String[] args) {
		int A = 5;
		int B[] = { 2, 4, 6, 8, 10 };
		System.out.println(maxChocolate(A, B));

	}

	private static int maxChocolate(int A, int[] B) {
		int mod = 1000000007;
		PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
		int sum = 0;
		for (int x : B)
			pq.offer(x);
		while (A > 0) {
			int x = pq.poll();
			sum = (sum % mod + x % mod) % mod;
			pq.offer(Math.abs(x / 2));
			A--;
		}
		return sum % mod;
	}
}
