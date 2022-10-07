package com.scaler.dsa.stack;

import java.util.Arrays;
import java.util.Stack;

/*
Problem Description
Given an array of integers A.
value of a array = max(array) - min(array).
Calculate and return the sum of values of all possible subarrays of A modulo 109+7.

Problem Constraints
1 <= |A| <= 100000
1 <= A[i] <= 1000000
Input Format
The first and only argument given is the integer array A.
Output Format
Return the sum of values of all possible subarrays of A modulo 109+7.

Input 1: A = [1]
Input 2: A = [4, 7, 3, 8]

Output 1: 0
Output 2: 26

Explanation 1:
Only 1 subarray exists. Its value is 0.

Explanation 2:
value ( [4] ) = 4 - 4 = 0
value ( [7] ) = 7 - 7 = 0
value ( [3] ) = 3 - 3 = 0
value ( [8] ) = 8 - 8 = 0
value ( [4, 7] ) = 7 - 4 = 3
value ( [7, 3] ) = 7 - 3 = 4
value ( [3, 8] ) = 8 - 3 = 5
value ( [4, 7, 3] ) = 7 - 3 = 4
value ( [7, 3, 8] ) = 8 - 3 = 5
value ( [4, 7, 3, 8] ) = 8 - 3 = 5
sum of values % 10^9+7 = 26

Optimization:
Value=Max(Subarray)-Min(SubArray)
Instead of calculating value of each subarray we should find the contribution of each element to the total sum.
	0	1  2   3  4   5
A[]={2, 10,12, 8, 13, 5}
	 i		   j      k
Number of subarrays where 8 will be minimum: {8} {12,8} {10,12,18} {8,13} {10,12,8,13} {12,8,13}
i=0, j=3, k=5

total number of subarrays where 8 will be minimum =(j-i)*(k-j)
=> (3-0)*(5-3)=3*2=6

We have to find for all i:

A[i]*(count of all the subarrays where it is max)*(count of all the subarrays where it is minimum)



 */
public class SumOfMAXAndMINOfAllSubarrays {

	public static void main(String[] args) {
		int A[] = { 4, 7, 3, 8 };
		System.out.println(subOfMaxAndMinNaive(A));
		System.out.println(subOfMaxAndMinEff(A));

	}
	private static int subOfMaxAndMinNaive(int[] A) {
		int n=A.length;
		int ans=0;
		for (int i = 0; i < n; i++) 
			for (int j = i; j < n; j++) 
				ans=ans+findMaxMinSum(A,i,j);

		return ans;
	}

	private static int findMaxMinSum(int[] A, int s, int e) {
		int min= Integer.MAX_VALUE;
		int max= Integer.MIN_VALUE;
		
		for (int i = s; i <= e; i++)
			if(A[i]>max)
				max=A[i];
		for (int i = s; i <= e; i++)
			if(A[i]<min)
				min=A[i];
			
		return max-min;
	}
	
	
	public static int subOfMaxAndMinEff(int[] A) {
	    //pre-compute all of this
	    int[] prevSmall = prevSmallerIndex(A);
	    int[] nextSmall = nextSmallerIndex(A);
	    int[] prevGreater = prevGreaterIndex(A);
	    int[] nextGreater = nextGreaterIndex(A);
	    int mod = 1000 * 1000 * 1000 + 7;

	    long ans = 0;
	    for (int i = 0; i < A.length; i++) {
	      //subarray in which A[i] is min
	      int p1 = prevSmall[i];
	      int p2 = nextSmall[i];
	      long prodMin = (1L * (i - p1) * (p2 - i)) % mod;
	      long minContribution = (prodMin * A[i]) % mod;

	      //subarray in which A[i] is max
	      int p3 = prevGreater[i];
	      int p4 = nextGreater[i];
	      long prodMax = (1L * (i - p3) * (p4 - i)) % mod;
	      long maxContribution = (prodMax * A[i]) % mod;

	      //computing ans
	      ans = (ans % mod) + ((maxContribution - minContribution) % mod);
	      ans = ans % mod;
	    }
	    if (ans < 0) {
	      ans = (ans + mod) % mod;
	    }
	    return (int)(ans % mod);
	  }

	  private static int[] prevSmallerIndex(int[] A) {
	    int N = A.length;
	    int[] ans = new int[N];
	    Arrays.fill(ans, -1);
	    Stack < Integer > stack = new Stack < > ();

	    for (int i = 0; i < N; i++) {
	      while (!stack.isEmpty() && A[i] <= A[stack.peek()]) {
	        stack.pop();
	      }
	      if (!stack.isEmpty()) {
	        ans[i] = stack.peek();
	      }
	      stack.push(i);
	    }
	    return ans;
	  }

	  private static int[] nextSmallerIndex(int[] A) {
	    int N = A.length;
	    int[] ans = new int[N];
	    Arrays.fill(ans, N); //edge case
	    Stack < Integer > stack = new Stack < > ();

	    for (int i = N - 1; i >= 0; i--) {
	      while (!stack.isEmpty() && A[i] <= A[stack.peek()]) {
	        stack.pop();
	      }
	      if (!stack.isEmpty()) {
	        ans[i] = stack.peek();
	      }
	      stack.push(i);
	    }
	    return ans;
	  }

	  private static int[] prevGreaterIndex(int[] A) {
	    int N = A.length;
	    int[] ans = new int[N];
	    Arrays.fill(ans, -1);
	    Stack < Integer > stack = new Stack < > ();

	    for (int i = 0; i < N; i++) {
	      while (!stack.isEmpty() && A[i] >= A[stack.peek()]) {
	        stack.pop();
	      }
	      if (!stack.isEmpty()) {
	        ans[i] = stack.peek();
	      }
	      stack.push(i);
	    }
	    return ans;
	  }

	  private static int[] nextGreaterIndex(int[] A) {
	    int N = A.length;
	    int[] ans = new int[N];
	    Arrays.fill(ans, N); //edge case
	    Stack < Integer > stack = new Stack < > ();

	    for (int i = N - 1; i >= 0; i--) {
	      while (!stack.isEmpty() && A[i] >= A[stack.peek()]) {
	        stack.pop();
	      }
	      if (!stack.isEmpty()) {
	        ans[i] = stack.peek();
	      }
	      stack.push(i);
	    }
	    return ans;
	  }

}
