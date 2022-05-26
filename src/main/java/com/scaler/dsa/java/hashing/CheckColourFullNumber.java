package com.scaler.dsa.java.hashing;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CheckColourFullNumber {

	public static void main(String[] args) {
		int n = 3245;
		int res = colorFul(n);
		System.out.println(res);

	}

	public static int colorFul(int A) {

		List<Integer> list = new ArrayList<>();
		Set<Integer> hs = new HashSet<>();

		while (A > 0) {
			int rem = A % 10;
			list.add(rem);
			A = A / 10;
		}
		Collections.reverse(list);
		for (int i = 0; i < list.size(); i++) {
			int prod = 1;
			for (int j = i; j < list.size(); j++) {
				prod = prod * list.get(j);
				if (hs.contains(prod))
					return 0;
				else
					hs.add(prod);
			}
		}
		return 1;

	}

}
