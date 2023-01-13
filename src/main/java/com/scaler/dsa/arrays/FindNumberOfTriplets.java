package com.scaler.dsa.arrays;

//Find number of triplets in the given array such that i<j<k and Arr[i]<arr[j]<arr[k]
public class FindNumberOfTriplets {

	public static void main(String[] args) {
		int arr[]= {3,4,6,9,2};
		
		int n= arr.length;
		int count=findNumberofTripletsNaive(arr,n);
		System.out.println(count);
		
		int count1=findNumberofTripletsEfficient(arr,n);
		System.out.println(count1);
		

	}

	//O(N^2) O(1)
	private static int findNumberofTripletsEfficient(int[] arr, int n) {
		int ans=0;
		for(int j=1;j<n-1;j++) {
			int leftsmall=0;
			for(int i=j-1;i>=0;i--)
				if(arr[j]>arr[i])
					leftsmall++;
			int rightlarge=0;
			for(int k=j+1;k<n;k++)
				if(arr[k]>arr[j])
					rightlarge++;
			ans+=leftsmall*rightlarge;
		}
		return ans;
	}

	//O(n^3) O(1)
	private static int findNumberofTripletsNaive(int[] arr, int n) {
		int ans=0;
		for(int i=0;i<n-2;i++)
			for(int j=i+1;j<n-1;j++)
				for(int k=j+1;k<n;k++)
					if(arr[i]<arr[j] && arr[j]<arr[k]) 
						ans++;
					
		
		return ans;
	}

}
