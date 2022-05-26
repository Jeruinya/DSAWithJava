package com.scaler.dsa.java.hashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class KOccurrences {

	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(2);
		list.add(2);
		list.add(3);
		list.add(3);
		int B = 2, A = 5;
		int res = getSum(A, B, list);
		System.out.println(res);

	}

	public static int getSum(int A, int B, ArrayList<Integer> C) {

		int sum = 0;
		boolean found = false;
		Map<Integer, Integer> hm = new HashMap<>();

		for (int i = 0; i <C.size(); i++) {
			if (hm.containsKey(C.get(i)))
				hm.put(C.get(i), hm.get(C.get(i)) + 1);
			else 
				hm.put(C.get(i), 1);
		}
		for (Map.Entry<Integer, Integer> entry : hm.entrySet()) {
			if (entry.getValue() == B) {
				sum = sum + entry.getKey();
				found = true;
			}
		}

		if (found == false)
			return -1;
		return sum % (10 ^ 9 + 7);
	}
}