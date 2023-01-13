package com.scaler.dsa.java.sequence;

import java.util.ArrayList;

/*
Problem Description
You are given an array of integers A of size N.
The value of a subarray is defined as BITWISE OR of all elements in it.
Return the sum of value of all subarrays of A % 109 + 7.
Problem Constraints
1 <= N <= 105
1 <= A[i] <= 108
Input Format
The first argument given is the integer array A.
Output Format
Return the sum of Value of all subarrays of A % 109 + 7.

Input 1: A = [1, 2, 3, 4, 5]
Input 2: A = [7, 8, 9, 10]

Output 1: 71
Output 2: 110

Explanation 1:
 Value([1]) = 1
 Value([1, 2]) = 3
 Value([1, 2, 3]) = 3
 Value([1, 2, 3, 4]) = 7
 Value([1, 2, 3, 4, 5]) = 7
 Value([2]) = 2
 Value([2, 3]) = 3
 Value([2, 3, 4]) = 7
 Value([2, 3, 4, 5]) = 7
 Value([3]) = 3
 Value([3, 4]) = 7
 Value([3, 4, 5]) = 7
 Value([4]) = 4
 Value([4, 5]) = 5
 Value([5]) = 5
 Sum of all these values = 71
Explanation 2:

 Sum of value of all subarray is 110.
 */
public class SUBARRAYOR {

	public static void main(String[] args) {
		int A[] = { 4,6,8 };
		System.out.println(solveNaive(A));

		System.out.println(solveEfficient(A));
		System.out.println(orSum(A));

	}
	
	 public static int orSum(int[] A) {
         long sum = 0;
        
         int mod=1000000007;
         for(int i=0;i<30;i++){
             ArrayList<Integer> list= new ArrayList<>();
             
             for(int j=0;j<A.length;j++){
                 if(((A[j]>>i)&1)==1)
                     list.add(1);
                 else
                     list.add(0);
             }
             long count=countOR1(list);
             sum=(sum%mod +(count*(long)(Math.pow(2,i)))%mod)%mod;

         }
  
         return (int) (sum % mod); 
     }

    public static long countOR1(ArrayList<Integer> list) {
         int c = 0;
         int n = list.size();
         long ans = 0;

         for (int i = 0; i < n; i++) {
             if (list.get(i) == 0)
                 c++;
             else {
                 ans = ans + ((1L*c*(1L*c+1)))/2;
                 c = 0;
             }
         }
         
         ans = ans + ((1L*c*(1L*c+1)))/2;
         
         long totalSubarrays=(1L*n*(1L*n+1))/2;
         return totalSubarrays-ans;

     }

	private static int solveEfficient(int[] A) {
		int n = A.length;
		int[] idx = new int[32];
		long ans = 0;
		for (int i = 1; i <= n; ++i) {
			long tmp = A[i - 1];
			for (int j = 0; j <= 31; ++j) {
				long pw = 1 << j;
				if ((tmp & pw) != 0) { // if jth bit is set
					ans += pw * i; // add its contribution in ans for all subarrays ending at index i
					idx[j] = i; // store the index for next elements
				} else if (idx[j] != 0) // if jth bit is not set
				{
					ans += pw * idx[j]; // add its contribution in ans for all subarrays ending at index i using
				} // the information of last element having jth bit set
			}
		}
		return (int) (ans % 1000000007);
	}

	public static int solveNaive(int[] A) {
		int mod = 1000000007;
		long ans = 0;
		for (int i = 0; i < A.length; i++) {
			int sum = 0;
			for (int j = i; j < A.length; j++) {
				sum = sum | A[j];
				ans = (ans % mod + sum % mod) % mod;
			}
		}
		return (int) (ans % mod); // taking mod for all subarray sum
	}
}
