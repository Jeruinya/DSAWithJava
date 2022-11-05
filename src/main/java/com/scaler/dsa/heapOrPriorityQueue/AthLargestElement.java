package com.scaler.dsa.heapOrPriorityQueue;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

/*
Problem Description
Given an integer array B of size N.

You need to find the Ath largest element in the subarray [1 to i], where i varies from 1 to N. In other words, 
find the Ath largest element in the sub-arrays [1 : 1], [1 : 2], [1 : 3], ...., [1 : N].
NOTE: If any subarray [1 : i] has less than A elements, then the output should be -1 at the ith index.

Problem Constraints
1 <= N <= 100000
1 <= A <= N
1 <= B[i] <= INT_MAX

Input Format
The first argument is an integer A.
The second argument is an integer array B of size N.

Output Format
Return an integer array C, where C[i] (1 <= i <= N) will have the Ath largest element in the subarray [1 : i].

Input 1:
 A = 4  
 B = [1 2 3 4 5 6] 
Input 2:
 A = 2
 B = [15, 20, 99, 1]


Output 1: [-1, -1, -1, 1, 2, 3]
Output 2: [-1, 15, 20, 20]

Explanation 1:
 for i <= 3 output should be -1.
 for i = 4, Subarray [1:4] has 4 elements 1, 2, 3 and 4. So, 4th maximum element is 1.
 for i = 5, Subarray [1:5] has 5 elements 1, 2, 3, 4 and 5. So, 4th maximum element is 2.
 for i = 6, Subarray [1:6] has 6 elements 1, 2, 3, 4, 5 and 6. So, 4th maximum element is 3.
 So, output array is [-1, -1, -1, 1, 2, 3].
 

Explanation 2:
 for i <= 1 output should be -1.
 for i = 2 , Subarray [1:2] has 2 elements 15 and 20. So, 2th maximum element is 15.
 for i = 3 , Subarray [1:3] has 3 elements 15, 20 and 99. So, 2th maximum element is 20.
 for i = 4 , Subarray [1:4] has 4 elements 15, 20, 99 and 1. So, 2th maximum element is 20.
 So, output array is [-1, 15, 20, 20].
 
 Approach: 
 1- we can use brute force approach to solve this problem as did below
 
 2-Optimization: We can use minimum heap to optimize this problem. we require minimum element of top A elements of current
   subarray.

So we can just build a heap of size A. Suppose the A 3 then we can build a min heap of size three and the top element of the
min heap will be the Ath largest element in that subarray.

if we will get a number which is greater than the top element of the min heap then we need to remove the top element and add new
element because it will give new Ath element.
 */
public class AthLargestElement {

	public static void main(String[] args) {
		int A = 4;
		int[] B = { 1, 2, 3, 4, 5, 6 };
		System.out.println(findBthLargestNumNaive(A, B));

		ArrayList<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		list.add(6);

		System.out.println(findBthLargestNumEff(list, 4));
	}

	// Time- O(NlogA) Space-O(N+A)
	public static ArrayList<Integer> findBthLargestNumEff(ArrayList<Integer> B, int A) {
		ArrayList<Integer> ans = new ArrayList<>();
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for (int i = 0; i < A; i++) {
			pq.add(B.get(i));
			if (pq.size() < A)
				ans.add(-1);
			else if (pq.size() == A)
				ans.add(pq.peek());
		}
		for (int i = A; i < B.size(); i++) {
			if (pq.peek() < B.get(i)) {
				pq.poll();
				pq.add(B.get(i));
			}
			ans.add(pq.peek());
		}
		return ans;
	}

	// Time- O(n*nlogn)
	private static List<Integer> findBthLargestNumNaive(int A, int[] B) {
		ArrayList<Integer> ans = new ArrayList<>();
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < B.length; i++) {
			list.add(B[i]);
			if (list.size() < A)
				ans.add(-1);
			else {
				list = list.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
				ans.add(list.get(A - 1));
			}
		}
		return ans;
	}

}
