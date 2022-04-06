package com.scaler.arrays;

public class ReversingArray {

	public static void main(String[] args) {
		int arr[] = { 10, 2, 3, 32, 54, 78, 90, 70, 40 };
		reverseArray(arr);
		
		for(int i:arr)
			System.out.print(i+" ");
		
		int arr1[] = { 10, 2, 3, 32, 54, 78, 90, 70, 40 };
			reverseArrayEfficient(arr1);
			
			System.out.println();

			for(int i:arr1)
				System.out.print(i+" ");
	}

	//T.C-O(n) and S.C-O(1)
	private static void reverseArrayEfficient(int[] arr1) {
		
		int low=0, high=arr1.length-1;
		while(low<high) {
			int temp=arr1[low];
			arr1[low]=arr1[high];
			arr1[high]=temp;
			low++;
			high--;
		}
		
		
	}

	//T.C-O(n) and S.C-O(n)
	private static void reverseArray(int[] arr) {
		int k = 0;
		int temp[] = new int[arr.length];

		for (int i = arr.length - 1; i >= 0; i--) {
			temp[k] = arr[i];
			k++;
		}
		for(int i=0;i<temp.length;i++)
			arr[i]=temp[i];
	}
}
