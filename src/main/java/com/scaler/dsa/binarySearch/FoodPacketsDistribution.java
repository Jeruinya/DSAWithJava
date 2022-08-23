package com.scaler.dsa.binarySearch;

/*
Problem Description
The government wants to set up B distribution offices across N cities for the distribution of food
packets. The population of the ith city is A[i]. Each city must have at least 1 office, and people can go 
to an office of their own city. We want to maximize the minimum number of people who can get food in any single office.

Problem Constraints
1 <= N <= 105
1 <= A[i] <= 106
1 <= B <= 5 x 105

Input Format
The first line of input contains an integer array A. 

The second line of input contains an integer B.
Output Format
Return one integer representing the maximum number of people who can get food in any single office.

Input 1:
  A = [10000, 20000, 30000]
  B = 6
Input 2:
  A = [1, 1, 1]
  B = 4

Output 1:  10000
Output 2:  0

Explanation 1:
  1 office can be opened in the first city,
  2 offices in the second city and
  3 in the third. This way ,
  10,000 people can get food in the office in the first city, and
  10,000 people can get food in each office in the second city and
  10,000 people can get food in third city.
  We will allot 10000 people in each office in the third city. 
  Had we alloted more in some office, we had to allot lesser in some other office which will reduce the answer.

Explanation 2:
  We will have to allot 2 offices to one city. And one of these offices would give food to 0 people.
  
  
Observation: here we have to find minimum number of people can we assign to B offices so that it can maximum.

 here we can take s as 1 and e as minimum element from the population array.
 
 now we have to find mid and check whether we can asign mid ppeople to B offices or not if yes then will try with bigger 
 value and if not possible then moven in left with smaller value of population.
 */
public class FoodPacketsDistribution {

	public static void main(String[] args) {
		int A[] = { 10000, 20000, 30000 };
		int B = 6;
		System.out.println(solve(A, B));
	}

	public static int solve(int[] A, int B) {

		int min = A[0];
		for (int i = 1; i < A.length; i++)
			if (A[i] < min)
				min = A[i];

		int s = 1;
		int e = min;
		int ans = 0;

		while (s <= e) {
			int mid = (s + e) / 2;
			if (isPossible(A, B, mid)) {
				ans = mid;
				s = mid + 1;
			} else
				e = mid - 1;
		}
		return ans;
	}

	public static boolean isPossible(int A[], int B, int mid) {
		long sum = 0;
		for (int i = 0; i < A.length; i++) {
			if (mid == 0)
				sum += A[i];
			else
				sum += (A[i] / mid);

		}
		return sum >= B;
	}
}
