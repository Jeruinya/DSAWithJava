package com.scaler.dsa.java.hashing;

import java.util.HashMap;
import java.util.Map;

public class OccuringMoreThanNbyKTimesEfficientSolONK {

	public static void main(String[] args) {
		int arr[] = new int[] { 30, 10, 20, 20, 20, 10, 40, 30, 30 };
		int n = arr.length;
		int k = 4;
		printNByKOccurrences(arr, n, k);
	}

	//This solution is best suitable when n is very large and kis very very small
	static void printNByKOccurrences(int arr[], int n, int k) {
		HashMap<Integer, Integer> m = new HashMap<Integer, Integer>();

		for (int i = 0; i < n; i++) {
			if (m.containsKey(arr[i])) {
				int count = m.get(arr[i]);
				m.put(arr[i], count + 1);
			} else if (m.size() < k - 1)
				m.put(arr[i], 1);
			else
				for (Map.Entry x : m.entrySet()) {
					Integer c = (Integer) x.getValue();
					m.put((Integer) x.getKey(), c - 1);
					if ((Integer) x.getKey() == 0)
						m.remove(x.getKey());
				}
		}
		for (Map.Entry x : m.entrySet()) {
			int count = 0;
			for (int i = 0; i < n; i++) {
				if ((Integer) x.getKey() == arr[i])
					count++;

			}
			if (count > n / k)
				System.out.print(x.getKey() + " ");
		}
	}

}
