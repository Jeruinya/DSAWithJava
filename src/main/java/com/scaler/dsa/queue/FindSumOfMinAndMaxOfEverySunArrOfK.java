package com.scaler.dsa.queue;

import java.util.ArrayDeque;
import java.util.Deque;

/*
Problem Description
Given an array A of both positive and negative integers.
Your task is to compute the sum of minimum and maximum elements of all sub-array of size B.
NOTE: Since the answer can be very large, you are required to return the sum modulo 109 + 7.

Problem Constraints
1 <= size of array A <= 105
-109 <= A[i] <= 109
1 <= B <= size of array

Input Format
The first argument denotes the integer array A.
The second argument denotes the value B

Output Format
Return an integer that denotes the required value.

Input 1:
 A = [2, 5, -1, 7, -3, -1, -2]
 B = 4
Input 2:
 A = [2, -1, 3]
 B = 2

Output 1: 18
Output 2: 3

Explanation 1:
 Subarrays of size 4 are : 
    [2, 5, -1, 7],   min + max = -1 + 7 = 6
    [5, -1, 7, -3],  min + max = -3 + 7 = 4      
    [-1, 7, -3, -1], min + max = -3 + 7 = 4
    [7, -3, -1, -2], min + max = -3 + 7 = 4   
    Sum of all min & max = 6 + 4 + 4 + 4 = 18 

Explanation 2:
 Subarrays of size 2 are : 
    [2, -1],   min + max = -1 + 2 = 1
    [-1, 3],   min + max = -1 + 3 = 2
    Sum of all min & max = 1 + 2 = 3 
    
Efficient Approach:
a) In deque 'G', we maintain decreasing order of 
    values from front to rear
 b) In deque 'S', we maintain increasing order of 
    values from front to rear

1) First window size K
  1.1) For deque 'G', if current element is greater 
       than rear end element, we remove rear while 
       current is greater.
  1.2) For deque 'S', if current element is smaller 
       than rear end element, we just pop it while 
       current is smaller.
  1.3) insert current element in both deque 'G' 'S'

2) After step 1, front of 'G' contains maximum element
   of first window and front of 'S' contains minimum 
   element of first window. Remaining elements of G
   and S may store maximum/minimum for subsequent 
   windows.

3) After that we do traversal for rest array elements.
  3.1) Front element of deque 'G' is greatest and 'S' 
       is smallest element of previous window 
  3.2) Remove all elements which are out of this 
       window [remove element at front of queue ]
  3.3) Repeat steps 1.1 , 1.2 ,1.3 

4) Return sum of minimum and maximum element of all 
   sub-array size k.
 */
public class FindSumOfMinAndMaxOfEverySunArrOfK {

	public static void main(String[] args) {
		int A[] = { 2, 5, -1, 7, -3, -1, -2 };
		int B = 4;
		System.out.println(findSumOfMinAndMax(A, B));

	}

	public static int solve(int[] A, int B) {
		int mod = 1000 * 1000 * 1000 + 7;
		Deque<Integer> min = new ArrayDeque<Integer>();
		Deque<Integer> max = new ArrayDeque<Integer>();
		int i = 0;
		for (; i < B; i++) {
			while (min.size() > 0 && A[min.getLast()] >= A[i]) {
				min.removeLast();
			}
			min.addLast(i);
			while (max.size() > 0 && A[max.getLast()] <= A[i]) {
				max.removeLast();
			}
			max.addLast(i);
		}
		long sum = A[min.getFirst()] + A[max.getFirst()];
		while (i < A.length) {
			while (min.size() > 0 && A[min.getLast()] >= A[i]) {
				min.removeLast();
			}
			min.addLast(i);
			while (i - min.getFirst() >= B) {
				min.removeFirst();
			}
			while (max.size() > 0 && A[max.getLast()] <= A[i]) {
				max.removeLast();
			}
			max.addLast(i);
			while (i - max.getFirst() >= B) {
				max.removeFirst();
			}
			sum += A[max.getFirst()] + A[min.getFirst()];
			sum %= mod;
			i++;
		}
		sum += mod;
		sum %= mod;
		return (int) sum;
	}

	private static int findSumOfMinAndMax(int[] A, int B) {
		int n = A.length;
		long sum = 0;
		int mod = 1000000007;
		for (int i = 0; i <= n - B; i++) {
			int min = A[i];
			int max = A[i];
			for (int j = i; j < B + i; j++) {
				if (A[j] > max)
					max = A[j];
				if (A[j] < min)
					min = A[j];
			}
			sum = sum + min + max;
			if (sum < 0)
				sum += mod;
			else
				sum = sum % mod;
		}
		return (int) sum;

	}

}
