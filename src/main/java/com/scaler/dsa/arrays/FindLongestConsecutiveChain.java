package com.scaler.dsa.arrays;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/*
Given a list of N Numbers which is unordered , find out the longest chain consecutive elements we can build.

for example: {21 3 5 7 4  1 2 6  9 10 12 11 13  20}

1->2->3->4->5->6->7    7
9->10->11->12->13	   5
20->21				   2
 */
public class FindLongestConsecutiveChain {

	public static void main(String[] args) {
		int A[] = { 21, 3, 5, 7, 4, 1, 2, 6, 9, 10, 12, 11, 13, 20 };

		List<Integer> list = Arrays.stream(A).boxed().collect(Collectors.toList());
		int longestChain = findLongestConsecutiveChain(list);
		System.out.println(longestChain);

		int longestChain1 = findLongestConsecutiveChainEfficient(A);
		System.out.println(longestChain1);

	}
	
	//TC-O(N) SC-O(N)
	private static int findLongestConsecutiveChainEfficient(int[] A) {

		Set<Integer> hs = new HashSet<>();
		for (int i : A)
			hs.add(i);

		int len = 0, longest = 0;

		for (int x : A) {
			if (!hs.contains(x - 1)) {
				len = 1;
				int num = x + 1;
				while (hs.contains(num)) {
					len++;
					num = num + 1;
				}
				longest = Math.max(len, longest);
			}
		}

		return longest;
	}

	// Tc-O(nlogn)
	private static int findLongestConsecutiveChain(List<Integer> list) {
		int maxChain = 0;
		int s = 0;
		int i = 0;
		Collections.sort(list);
		for (; i < list.size() - 1; i++) {
			if (list.get(i) + 1 == list.get(i + 1))
				continue;
			else {
				int len = i - s + 1;
				if (len > maxChain)
					maxChain = Math.max(maxChain, i - s + 1);
				s = i + 1;
			}
		}
		int len = i - s + 1;
		maxChain = Math.max(maxChain, len);

		return maxChain;
	}

}
