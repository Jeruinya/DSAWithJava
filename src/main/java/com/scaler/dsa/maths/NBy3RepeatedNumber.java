package com.scaler.dsa.maths;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
Problem Description
You're given a read-only array of N integers. Find out if any integer occurs more than N/3 times in 
the array in linear time and constant additional space.
If so, return the integer. If not, return -1.

If there are multiple solutions, return any one.
 */
public class NBy3RepeatedNumber {

	public static void main(String[] args) {

		int A[] = { 1000697, 1000110, 1000110, 1000671, 1000941, 1000304, 1000110, 1000742, 1000160, 1000558, 1000110,
				1000110, 1000110, 1000650, 1000200, 1000110, 1000133, 1000110, 1000548, 1000002, 1000397, 1000110,
				1000533, 1000724, 1000110, 1000882, 1000110, 1000515, 1000110, 1000110, 1000110, 1000181, 1000051,
				1000110, 1000110, 1000644, 1000110, 1000301, 1000110, 1000040, 1000424, 1000336, 1000426, 1000244,
				1000485, 1000439, 1000554, 1000110, 1000110, 1000497, 1000836, 1000760, 1000110, 1000135, 1000872,
				1000110, 1000739, 1000242, 1000790, 1000110, 1000384, 1000110, 1000384, 1000110, 1000713, 1000110,
				1000110, 1000048, 1000110, 1000172, 1000727, 1000502, 1000649, 1000830, 1000387, 1000953, 1000110,
				1000640, 1000291, 1000612, 1000389, 1000110, 1000698, 1000462, 1000054, 1000110, 1000110, 1000181,
				1000221, 1000408, 1000110, 1000905, 1000110, 1000532, 1000939, 1000110, 1000817, 1000388, 1000069,
				1000110, 1000163, 1000453, 1000847, 1000908, 1000395, 1000574, 1000127, 1000132, 1000110, 1000110,
				1000201, 1000689 };
		ArrayList<Integer> a =new ArrayList<>();
		
		for(int i=0;i<A.length;i++)
			a.add(A[i]);
		int res = repeatedNumber(a);
		System.out.println(res);
	}

	public static int repeatedNumber(final List<Integer> A) {
		int num;
		int n = A.size();
		Collections.sort(A);
		for (int i = 0; i < n;) {
			int freq = 0;
			num = A.get(i);
			while (i < n && A.get(i) == num) {
				freq++;
				i++;
			}
			if (freq> n/3)
				return num;
		}
		return -1;
	}
}