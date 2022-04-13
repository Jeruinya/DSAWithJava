package com.dsa.scaler.arrays;

public class FindSumOfAllTheSubarraysSum {

	public static void main(String[] args) {
		int arr[]= {10,20,30};
		int n=arr.length;
		int sum= sumOfAllSubarraysSum(arr,n);
		System.out.println(sum);

	}

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
