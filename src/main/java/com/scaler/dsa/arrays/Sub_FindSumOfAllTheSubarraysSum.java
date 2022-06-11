package com.scaler.dsa.arrays;

public class Sub_FindSumOfAllTheSubarraysSum {

	public static void main(String[] args) {
		int arr[]= {10,20,30};
		int n=arr.length;
		int sum= sumOfAllSubarraysSum(arr,n);
		System.out.println(sum);
		
		int sum1= sumOfAllSubarraysSumEfficient(arr,n);
		System.out.println(sum1);

	}

	//O(n) O(1)
	private static int sumOfAllSubarraysSumEfficient(int[] arr, int n) {
		int ans=0;
		for(int i=0;i<n;i++)
			ans+=arr[i]*(i+1)*(n-i);
		return ans;
	}

	//O(n^2) O(1)
	private static int sumOfAllSubarraysSum(int[] arr, int n) {
		int ans=0;
		for(int s=0;s<n;s++) {
			int sum=0;
			for(int e=s;e<n;e++) {
				sum=sum+arr[e];
				ans=ans+sum;
			}
		}
		return ans;
	}

}
