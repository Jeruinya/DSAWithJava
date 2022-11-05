package com.scaler.dsa.heapOrPriorityQueue;

import java.util.PriorityQueue;

/*
Problem Description
You are given an array A of integers that represent the lengths of ropes.
You need to connect these ropes into one rope. The cost of joining two ropes equals the sum of their lengths.
Find and return the minimum cost to connect these ropes into one rope.

Problem Constraints
1 <= length of the array <= 100000
1 <= A[i] <= 1000

Input Format
The only argument given is the integer array A.

Output Format
Return an integer denoting the minimum cost to connect these ropes into one rope.

Input 1: A = [1, 2, 3, 4, 5]
Input 2: A = [5, 17, 100, 11]

Output 1: 33
Output 2: 182

Explanation 1:
 Given array A = [1, 2, 3, 4, 5].
 Connect the ropes in the following manner:
 1 + 2 = 3
 3 + 3 = 6
 4 + 5 = 9
 6 + 9 = 15

 So, total cost  to connect the ropes into one is 3 + 6 + 9 + 15 = 33.

Explanation 2:
 Given array A = [5, 17, 100, 11].
 Connect the ropes in the following manner:
 5 + 11 = 16
 16 + 17 = 33
 33 + 100 = 133

So, total cost  to connect the ropes into one is 16 + 33 + 133 = 182.

A = [5,7,10]
			1-cost=12+22=34
			2-cost=117+22=39
			3-cost=15+25=37

1- pick 5 and 7   5+7=12
Array became A=[12,10]
	now pick 12 and 10 12+10= 22
	
2- pick 7 and 10   7+10=17
Array became A=[5,17]
	now pick 5 and 17 , 5+17= 22
	
3- pick 5 and 10   5+10=15
Array became A=[15,10]
	now pick 15 and 10 15+10= 25
	
From the above example explanation we can see if we pick always minimum two elements from the array then we can minimize 
the cost of joining the rope.

To get the minimum element we can take min heap.
 */
public class ConnectRopes {

	public static void main(String[] args) {
		int A[]= {5, 17, 100, 11};
		System.out.println(findMinCost(A));

	}

	private static int findMinCost(int[] A) {
		PriorityQueue<Integer> pq= new PriorityQueue<Integer>();
		int sum=0;
		for(int x:A)
			pq.offer(x);
		while(pq.size()!=1) {
			int a=pq.poll();
			int b=pq.poll();
			sum+=a+b;
			pq.offer(a+b);
		}
		return sum;
	}

}
