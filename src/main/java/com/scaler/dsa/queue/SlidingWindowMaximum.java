package com.scaler.dsa.queue;

/*
Problem Description
Given an array of integers A. There is a sliding window of size B, moving from the very left of the array to the very right.
 You can only see the B numbers in the window. Each time the sliding window moves rightwards by one position. 
 You have to find the maximum for each window.
Return an array C, where C[i] is the maximum value in the array from A[i] to A[i+B-1].
Refer to the given example for clarity.

NOTE: If B > length of the array, return 1 element with the max of the array.

Problem Constraints
1 <= |A|, B <= 106

Input Format
The first argument given is the integer array A.
The second argument given is the integer B.

Output Format
Return an array C, where C[i] is the maximum value of from A[i] to A[i+B-1].

Input 1:
 A = [1, 3, -1, -3, 5, 3, 6, 7]
 B = 3
Input 2:
 A = [1, 2, 3, 4, 2, 7, 1, 3, 6]
 B = 6

Output 1: [3, 3, 5, 5, 6, 7]
Output 2: [7, 7, 7, 7]

Explanation 1:
 Window position     | Max
 --------------------|-------
 [1 3 -1] -3 5 3 6 7 | 3
 1 [3 -1 -3] 5 3 6 7 | 3
 1 3 [-1 -3 5] 3 6 7 | 5
 1 3 -1 [-3 5 3] 6 7 | 5
 1 3 -1 -3 [5 3 6] 7 | 6
 1 3 -1 -3 5 [3 6 7] | 7

Explanation 2:
 Window position     | Max
 --------------------|-------
 [1 2 3 4 2 7] 1 3 6 | 7
 1 [2 3 4 2 7 1] 3 6 | 7
 1 2 [3 4 2 7 1 3] 6 | 7
 1 2 3 [4 2 7 1 3 6] | 7
 
 Optimization:
 Deque based algorithm :
 
A[]={10,1,8,9,7,6,5,11,3}

->Put elements in Deque one by one. first put k elements in the Deque and then remaining.
->Before inserting any elements , remove all the elements at the back which which are smaller then the element inserting 
  into Deque from array.
->Maximum element of the window of size k always will be at front.
->Check window size every time to make sure that the front element is within window. and if not within window just remove it.

 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class SlidingWindowMaximum {

	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(10, 9, 8, 7, 6, 5, 4, 3, 2, 1);
		System.out.println(slidingMaximum(list, 2));

		System.out.println(slidingMaximumEff(list, 2));

	}

	public static ArrayList<Integer> slidingMaximumEff(final List<Integer> A, int B) {
		int n = A.size();
		Deque<Integer> q = new LinkedList<>();
		ArrayList<Integer> list = new ArrayList<>();

		for (int i = 0; i < B; i++) {
			// remove smaller elements
			while (!q.isEmpty() && A.get(i) >= A.get(q.getLast()))
				q.removeLast();
			q.addLast(i);
		}

		for (int i = B; i < n; i++) {
			list.add(A.get(q.getFirst()));
			// remove elements from the front whose indices are not in the window.
			while (!q.isEmpty() && q.getFirst() <= i - B)
				q.removeFirst();
			// Remove smaller elements from back before pushing current element
			while (!q.isEmpty() && A.get(i) >= A.get(q.getLast()))
				q.removeLast();
			q.addLast(i);

		}
		list.add(A.get(q.getFirst()));
		return list;
	}

	// Time Complexity O(n*B)
	public static ArrayList<Integer> slidingMaximum(final List<Integer> A, int B) {

		int n = A.size();
		ArrayList<Integer> list = new ArrayList<>();

		for (int i = 0; i <= n - B; i++) {
			int max = A.get(i);
			for (int j = i; j <= i + B - 1; j++) {
				max = Math.max(max, A.get(j));
			}

			list.add(max);
		}
		return list;
	}

}
