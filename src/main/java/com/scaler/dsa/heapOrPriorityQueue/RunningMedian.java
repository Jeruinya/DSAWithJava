package com.scaler.dsa.heapOrPriorityQueue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

/*
Problem Description
Given an array of integers, A denoting a stream of integers. New arrays of integer B and C are formed.
Each time an integer is encountered in a stream, append it at the end of B and append the median of array B at the C.
Find and return the array C.

NOTE:
If the number of elements is N in B and N is odd, then consider the median as B[N/2] ( B must be in sorted order).
If the number of elements is N in B and N is even, then consider the median as B[N/2-1]. ( B must be in sorted order).

Problem Constraints
1 <= length of the array <= 100000
1 <= A[i] <= 109

Input Format
The only argument given is the integer array A.

Output Format
Return an integer array C, C[i] denotes the median of the first i elements.

Input 1: A = [1, 2, 5, 4, 3]
Input 2: A = [5, 17, 100, 11]

Output 1: [1, 1, 2, 2, 3]
Output 2: [5, 5, 17, 11]

Explanation 1:
 stream          median
 [1]             1
 [1, 2]          1
 [1, 2, 5]       2
 [1, 2, 5, 4]    2
 [1, 2, 5, 4, 3] 3

Explanation 2:
 stream          median
 [5]              5
 [5, 17]          5
 [5, 17, 100]     17
 [5, 17, 100, 11] 11 
 
Approach: 

B= B0, B1, B2, B3, B4			First sorted half=B0, B2, B2
								Second sorted half=B3, B4
Here N= 5 so Median =5/2=>2 B[2] = B2.

B= B0, B1, B2, B3, B4, B5			First sorted half=B0, B2, B2
								   Second sorted half=B3, B4, B5
Here N=6 
		and Median= 6/2-1=> 3-1=2  i.e B[2]=B2
So median always will exist in the first sorted half array.

 */
public class RunningMedian {

	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(1, 2, 5, 4, 3);

		List<Integer> ans = findMedain(list);
		System.out.println(ans);
	}

	private static List<Integer> findMedain(List<Integer> A) {

		PriorityQueue<Integer> max = new PriorityQueue<>(Collections.reverseOrder());
		PriorityQueue<Integer> min = new PriorityQueue<>();

		ArrayList<Integer> ans = new ArrayList<>();
		ans.add(A.get(0));
		max.add(A.get(0));

		for (int i = 1; i < A.size(); i++) {
			if (A.get(i) > max.peek())
				min.add(A.get(i));
			else
				max.add(A.get(i));
			int s1 = max.size();
			int s2 = min.size();

			if (s1 - s2 > 1) {
				int num = max.poll();
				min.add(num);
			} else if (s1 - s2 < 0) {
				int num = min.poll();
				max.add(num);
			}
			ans.add(max.peek());
		}
		return ans;

	}

}
