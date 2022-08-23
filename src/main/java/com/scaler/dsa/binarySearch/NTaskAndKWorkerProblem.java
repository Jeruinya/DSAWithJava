package com.scaler.dsa.binarySearch;

/*
Given N tasks and K workers.
Time to finish each task {3,5,7,6,2,10} k= 3 workers

condition:
1:	Each worker will execute a set of continuous task.
2:	All workers start doing task at the same time.

Find the minimum time required to finish all the task.

Example 1:
Input: jobs = [3,2,3], k = 3
Output: 3
Explanation: By assigning each person one job, the maximum time is 3.

Example 2:
Input: jobs = [1,2,4,7,8], k = 2
Output: 11

Explanation: Assign the jobs the following way:
Worker 1: 1, 2, 8 (working time = 1 + 2 + 8 = 11)
Worker 2: 4, 7 (working time = 4 + 7 = 11)
The maximum working time is 11.

A[]={3,5,7,6,2,10} k=3

k1=[3,5,7]=15 mins
k2=[6,2]  =8 mins
k3=[10]	=10 mins    so max time to finish all the tasks by 3 workers simultaneously will be 15 mins.

k1=[3,5] =8 mins
k2=[7,6] =13 mins
k3=[2,10]= 12 mins    max time is 13 mins

So same like that we have to consider all the possible ways and find the minimum one.

 */
public class NTaskAndKWorkerProblem {

	public static void main(String[] args) {
		int A[] = { 3, 5, 7, 6, 2, 10 };
		int k = 3;
		System.out.println(minimumTimeToFinish(A, k));

	}

	private static int minimumTimeToFinish(int[] A, int k) {
		int sum = 0;
		for (int i : A)
			sum += i;
		int s = 0;
		int e = sum;
		int ans = e;
		while (s <= e) {
			int mid = (s + e) / 2;
			if (canDo(A, mid, k)) {
				ans = mid;
				e = mid - 1;
			} else
				s = mid + 1;
		}

		return ans;
	}

	//TC-O(nlogn)
	private static boolean canDo(int[] A, int mid, int k) {
		int count = 1;
		int t = 0;
		for (int i = 0; i < A.length; i++) {
			if (t + A[i] <= mid)
				t = t + A[i];
			else {
				t = A[i];
				count++;
				if (count > k)
					return false;
			}
		}
		return true;
	}
}
