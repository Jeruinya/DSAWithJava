package com.scaler.dsa.arrays;

public class FindSmallestSubArrayWithMaxAndMinElementsT {

	public static void main(String[] args) {
		int A[] = { 2, 2, 6, 4, 5, 1, 5, 2, 6, 4, 1 };

		int ans = smallestSubarrayWithMinAndMaxElemNaive(A);
		System.out.println(ans);

		int ans1 = smallestSubarrayWithMinAndMaxElemEfficient(A);
		System.out.println(ans1);

	}

	//O(n) and O(1)
	private static int smallestSubarrayWithMinAndMaxElemEfficient(int[] a) {
		int ans = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		int lat_max = Integer.MIN_VALUE;
		int lat_min = Integer.MIN_VALUE;
		int n = a.length;

		for (int i = 0; i < n; i++)
			if (a[i] > max)
				max = a[i];
		for (int i = 0; i < n; i++)
			if (a[i] < min)
				min = a[i];

		if (max == min)
			return 1;

		for (int i = 0; i < n; i++) {
			if (a[i] == max) {
				lat_max = i;
				if (lat_min >= 0)
					ans = Math.min(ans, i - lat_min + 1);

			} else if (a[i] == min) {
				lat_min = i;
				if (lat_max >= 0)
					ans = Math.min(ans, i - lat_max + 1);
			}
		}

		return ans;
	}

	// Tc=O(N2) , SC--O(1)
	private static int smallestSubarrayWithMinAndMaxElemNaive(int[] a) {
		int ans = Integer.MAX_VALUE;
		int n = a.length;
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		int start=-1,end=-1;

		for (int i = 0; i < n; i++)
			if (a[i] > max)
				max = a[i];
		for (int i = 0; i < n; i++)
			if (a[i] < min)
				min = a[i];

		for (int i = 0; i < n; i++) {
			if (a[i] == max) {
				for (int j = i; j < n; j++) {
					if (a[j] == min) {
						ans = Math.min(ans, j - i + 1);
						start=i;
						end=j;
						break;
					}
				}
			} else if (a[i] == min) {
				for (int j = i; j < n; j++) {
					if (a[j] == max) {
						ans = Math.min(ans, j - i + 1);
						start=i;
						end=j;
						break;
					}
				}
			}
		}
		
		for(int i=start;i<=end;i++)
			System.out.println(a[i]);

		return ans;
	}

}
