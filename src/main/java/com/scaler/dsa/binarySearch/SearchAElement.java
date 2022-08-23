package com.scaler.dsa.binarySearch;

public class SearchAElement {

	public static void main(String[] args) {
		int A[] = { 3, 5, 8, 10, 15, 20, 25 };
		int t = 15;
		System.out.println(searchElement(A, t));

		String S[] = { "App", "Apple", "Bat", "Batman", "man", "Mango", "Zebra" };
		String str = "Mango";
		System.out.println(searchStringElement(S, str));

	}

	private static String searchStringElement(String[] A, String str) {
		int s = 0;
		int e = A.length - 1;
		while (s <= e) {
			int mid = (s + e) / 2;
			if (A[mid].equals(str)) {
				return A[mid];
			} else if (A[mid].equals(str))
				e = mid - 1;
			else
				s = mid + 1;
		}
		return "";
	}

	private static int searchElement(int[] A, int t) {

		int s = 0;
		int e = A.length - 1;
		while (s <= e) {
			int mid = (s + e) / 2;
			if (A[mid] == t) {
				return A[mid];
			} else if (A[mid] > t)
				e = mid - 1;
			else
				s = mid + 1;
		}
		return -1;
	}

}
