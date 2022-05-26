package com.scaler.dsa.java.hashing;

import java.util.HashMap;
import java.util.Map;

public class KOccurrencesOfTree {

	public static void main(String[] args) {
		int C[] = { 1, 2, 2, 3, 3 };
		int A = 5, B = 2;
		int res = getSum(A, B, C);
		System.out.println(res);
	}

	public static int getSum(int A, int B, int[] C) {
		Map<Integer, Integer> hm = new HashMap<>();
		boolean flag = false;
		long sum = 0;
		for (int i = 0; i < C.length; i++) {
			if (hm.containsKey(C[i])) {
				hm.put(C[i], hm.get(C[i]) + 1);
				C[i] = -1;
			} else
				hm.put(C[i], 1);
		}
		for (int i = 0; i < C.length; i++) {
			if ((C[i] == -1) && (hm.get(C[i]) == B)) {
				flag = true;
				sum = sum + C[i];
			}
		}
		if (flag == false)
			return -1;
		return (int) sum % (7 + 10 ^ 9);
	}

}
