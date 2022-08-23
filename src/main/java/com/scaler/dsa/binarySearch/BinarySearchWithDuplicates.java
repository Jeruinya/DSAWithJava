package com.scaler.dsa.binarySearch;

public class BinarySearchWithDuplicates {

	public static void main(String[] args) {
		int A[] = { 1,1,2,3,3,3,3,3, 4, 5, 8, 10,10 };
		int t = 3;
		System.out.println(binarySearcht(A, t));

	}

	private static int binarySearcht(int[] A, int t) {
		int s = 0;
		int e = A.length - 1;
		int ans = -1;
		while (s <= e) {
			int mid = (s + e) / 2;
			if (A[mid] == t) {
				ans = mid;
				e = mid - 1;
			} else if (A[mid] > t)
				e = mid - 1;
			else
				s = mid + 1;
		}
		return ans+1;
	}
}
