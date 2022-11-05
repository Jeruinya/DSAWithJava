package com.scaler.dsa.heapOrPriorityQueue;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/*
Problem Description
Given a sorted array of integers A which contains 1 and some number of primes.
Then, for every p < q in the list, we consider the fraction p / q.
What is the B-th smallest fraction considered?
Return your answer as an array of integers, where answer[0] = p and answer[1] = q.

Problem Constraints
1 <= length(A) <= 2000
1 <= A[i] <= 30000
1 <= B <= length(A)*(length(A) - 1)/2

Input Format
The first argument of input contains the integer array, A.
The second argument of input contains an integer B.


Output Format
Return an array of two integers, where answer[0] = p and answer[1] = q.

Input 1:
 A = [1, 2, 3, 5]
 B = 3
Input 2:
 A = [1, 7]
 B = 1


Example Output
Output 1: [2, 5]
Output 2: [1, 7]

Explanation 1:
 The fractions to be considered in sorted order are:
 [1/5, 1/3, 2/5, 1/2, 3/5, 2/3]
 The third fraction is 2/5.

Explanation 2:
 The fractions to be considered in sorted order are:
 [1/7]
 The first fraction is 1/7.
 */
public class BthSmallestPrimeFraction {

	public static class Tuple {
		double ratio;
		int x;
		int y;

		public Tuple(double ratio, int x, int y) {
			this.ratio = ratio;
			this.x = (int) x;
			this.y = (int) y;
		}
	}

	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(5);
		int B = 3;
		System.out.println(findBthSmallestFractionNaive(list, B));
		System.out.println(findBthSmallestFractionEff(list, B));
	}

	public int[] solve(int[] A, int B) {
		int K = B;
		PriorityQueue<Pair> q = new PriorityQueue<Pair>(new CustomComp());
		Map<Integer, Integer> hm = new HashMap<Integer, Integer>();
		for (int i = A.length - 1; i > 0; i--) {
			if (hm.containsKey(A[i]) == true)
				hm.replace(A[i], A[i - 1]);
			else
				hm.put(A[i], A[i - 1]);
		}

		double last = (double) A[A.length - 1];
		double d;
		if (hm.containsKey(1) == true)
			hm.replace(1, 0);
		else
			hm.put(1, 0);

		for (int i = 0; i < A.length; i++) {
			d = (double) A[i] / last;
			q.offer(new Pair(d, A[i], (int) last));
		}

		while (q.size() > 0 && K > 0) {
			K--;
			if (K == 0)
				break;
			Pair p = q.poll();
			if (hm.containsKey(p.tt) == true && hm.get(p.tt) != 0) {
				p.tt = hm.get(p.tt);
				d = (double) p.ss / (double) p.tt;
				q.offer(new Pair(d, p.ss, p.tt));
			}
		}
		int[] ret = new int[2];
		ret[0] = q.peek().ss;
		ret[1] = q.peek().tt;

		return ret;
	}

	public static ArrayList<Integer> findBthSmallestFractionEff(ArrayList<Integer> A, int B) {
		ArrayList<Integer> output = new ArrayList<>();
		PriorityQueue<Tuple> pq = new PriorityQueue<>(Comparator.comparing(x -> x.ratio));
		// Now in this priority queue we can have several groups of same denominator
		int n = A.size();
		double last = A.get(n - 1);

		for (int i = 0; i < n - 1; ++i) {
			pq.add(new Tuple(A.get(i) / last, i, n - 1));
		}
		// Removing b-1 from minHeap will lead root as answer
		for (int i = 1; i < B; ++i) {
			Tuple top = pq.poll();
			if (top.y - 1 > top.x) {
				pq.add(new Tuple((A.get(top.x) / (0.0 + A.get(top.y - 1))), top.x, top.y - 1));
			}
		}
		Tuple p = pq.poll();
		output.add(A.get(p.x));
		output.add(A.get(p.y));
		return output;
	}

	public static ArrayList<Integer> findBthSmallestFractionNaive(ArrayList<Integer> A, int B) {
		ArrayList<Integer> res = new ArrayList<>();
		ArrayList<Tuple> list = new ArrayList<Tuple>();

		for (int i = 0; i < A.size(); i++)
			for (int j = i + 1; j < A.size(); j++)
				if (A.get(i) < A.get(j))
					list.add(new Tuple(A.get(i) / A.get(j), A.get(i), A.get(j)));

		// Sort list and find B-1th pair and then get x and y.

		Tuple p = list.get(B - 1);
		res.add(p.x);
		res.add(p.y);

		return res;
	}

}

class Pair {
	double ff;
	int ss;
	int tt;

	public Pair(double c, int d, int e) {
		this.ff = c;
		this.ss = d;
		this.tt = e;
	}
}

class CustomComp implements Comparator<Pair> {
	@Override
	public int compare(Pair a, Pair b) {
		if (a.ff > b.ff)
			return 1;
		return -1;
	}
}
