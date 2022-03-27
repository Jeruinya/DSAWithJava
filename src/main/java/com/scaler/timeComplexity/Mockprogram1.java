package com.scaler.timeComplexity;

//print [1,2,3,4,5,5,6]
//1
//23
//455
//6

//O(n) as number of iterations is equal to size of array
public class Mockprogram1 {
	public static void main(String[] args) {
		int arr[] = { 1, 2, 3, 4, 5, 5, 6 };
		int k = 0;
		for (int i = 0; i < arr.length;) {
			for (int j = 0; j <= k; j++) {
				if (i > arr.length-1) {
					break;
				} else {
					System.out.print(arr[i]+" ");
					i++;
				}
			}
			k++;
			System.out.println();
		}
	}

}
