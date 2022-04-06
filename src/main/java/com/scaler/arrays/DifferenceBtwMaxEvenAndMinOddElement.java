package com.scaler.arrays;

public class DifferenceBtwMaxEvenAndMinOddElement {

	public static void main(String[] args) {

		int A[] = {-92, 22, 2, 11, 39, 36, 36, 51, 71, 42,0};

		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < A.length; i++) {
			if (A[i] % 2 == 0 && A[i] > max) {
					max = A[i];
			}
			else if(A[i]%2!=0 && A[i]!=0)
				min = Integer.min(min, A[i]);
			
		}
		System.out.println(max - min);
	}

}
