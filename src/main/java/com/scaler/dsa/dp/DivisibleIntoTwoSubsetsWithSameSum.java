package com.scaler.dsa.dp;

/*
The partition problem is to determine whether a given set can be partitioned into two subsets such that the 
sum of elements in both subsets is the same. 

Examples: 
Input: A[] = {1, 5, 11, 5}
Output: true 
The array can be partitioned as {1, 5, 5} and {11}

Input: A[] = {1, 5, 3}
Output: false 
The array cannot be partitioned into equal sum sets.


Approach:
Follow the below steps to solve the problem:

First, check if the sum of the elements is even or not
After checking, call the recursive function isSubsetSum with parameters as input array, array size, and sum/2
If the sum is equal to zero then return true (Base case)
If n is equal to 0 and sum is not equal to zero then return false (Base case)
Check if the value of the last element is greater than the remaining sum then call this function again by removing the last element
else call this function again for both the cases stated above and return true, if anyone of them returns true
Print the answer


Let isSubsetSum(arr, n, sum/2) be the function that returns true if there is a subset of arr[0..n-1] with sum equal to sum/2
The isSubsetSum problem can be divided into two subproblems

 -isSubsetSum() without considering last element (reducing n to n-1)
 -isSubsetSum considering the last element (reducing sum/2 by arr[n-1] and n to n-1)
If any of the above subproblems return true, then return true. 
isSubsetSum (arr, n, sum/2) = isSubsetSum (arr, n-1, sum/2) || isSubsetSum (arr, n-1, sum/2 – arr[n-1])
 */

public class DivisibleIntoTwoSubsetsWithSameSum {

	public static void main(String[] args) {
		int A[] = { 3, 1, 5, 9, 12 };
		System.out.println(findPartition(A,A.length));

	}
	
	 static boolean findPartition(int arr[], int n)
	    {
	        // Calculate sum of the elements in array
	        int sum = 0;
	        for (int i = 0; i < n; i++)
	            sum += arr[i];
	 
	        // If sum is odd, there cannot be two subsets
	        // with equal sum
	        if (sum % 2 != 0)
	            return false;
	 
	        // Find if there is subset with sum equal to half
	        // of total sum
	        return isSubsetSum(arr, n, sum / 2);
	    }
	 
	 static boolean isSubsetSum(int arr[], int n, int sum)
	    {
	        // Base Cases
	        if (sum == 0)
	            return true;
	        if (n == 0 && sum != 0)
	            return false;
	 
	        // If last element is greater than sum, then ignore
	        // it
	        if (arr[n - 1] > sum)
	            return isSubsetSum(arr, n - 1, sum);
	 
	        /* else, check if sum can be obtained by any of
	           the following
	        (a) including the last element
	        (b) excluding the last element
	        */
	        return isSubsetSum(arr, n - 1, sum)
	            || isSubsetSum(arr, n - 1, sum - arr[n - 1]);
	    }

}
