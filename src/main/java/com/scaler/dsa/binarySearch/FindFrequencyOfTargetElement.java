package com.scaler.dsa.binarySearch;

public class FindFrequencyOfTargetElement {

	public static void main(String[] args) {
		int A[] = { 1, 1, 2, 3, 3, 3, 3, 3, 4, 5, 8, 10, 10 };
		int T = 3;
		int start = startIndex(A, T);
		int end = endIndex(A, T);
		System.out.println(end - start + 1);

	}

	private static int startIndex(int[] A, int t) {
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
		return ans;
	}

	private static int endIndex(int[] A, int t) {
		int s = 0;
		int e = A.length - 1;
		int ans = -1;
		while (s <= e) {
			int mid = (s + e) / 2;
			if (A[mid] == t) {
				ans = mid;
				s = mid + 1;
			} else if (A[mid] > t)
				e = mid - 1;
			else
				s = mid + 1;
		}
		return ans;
	}
}
