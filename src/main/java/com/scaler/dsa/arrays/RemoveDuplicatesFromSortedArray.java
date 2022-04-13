package com.scaler.dsa.arrays;

public class RemoveDuplicatesFromSortedArray {

	public static void main(String[] args) {
		int arr[] = { 10, 10, 20, 20, 30, 30, 40, 40, 50 };
		System.out.println("Before Duplicate Removal:");
		for (int i : arr)
			System.out.print(i + " ");
		System.out.println();
		int index = removeDuplicatesNaive(arr);

		System.out.println("After Duplicate Removal:");
		for (int i = 0; i < index; i++)
			System.out.print(arr[i] + " ");
		
		int arr1[] = { 10, 10, 20, 20, 30, 30, 40, 40, 50 };

		int index1 = removeDuplicatesEfficient(arr1);
		System.out.println("After Duplicate Removal Efficient Solution:");
		for (int i = 0; i < index1; i++)
			System.out.print(arr1[i] + " ");

	}

	private static int removeDuplicatesEfficient(int[] arr) {
		int res=1;
		for(int i=1;i<arr.length;i++) {
			if(arr[i]!=arr[res-1]) {
				arr[res]=arr[i];
				res++;
			}
		}
		return res;
	}

	private static int removeDuplicatesNaive(int[] arr) {
		int temp[] = new int[arr.length];
		temp[0] = arr[0];
		int res = 1;
		for (int i = 0; i < arr.length; i++) {
			if (temp[res - 1] != arr[i]) {
				temp[res] = arr[i];
				res++;
			}
		}
		for (int i = 0; i < res; i++)
			arr[i] = temp[i];

		return res;
	}

}
