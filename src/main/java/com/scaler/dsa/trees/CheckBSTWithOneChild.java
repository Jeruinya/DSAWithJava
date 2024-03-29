package com.scaler.dsa.trees;

import java.util.Arrays;
import java.util.List;

/*
Problem Description
Given preorder traversal of a binary tree, check if it is possible that it is also a preorder traversal of a 
Binary Search Tree (BST), where each internal node (non-leaf nodes) have exactly one child.

Problem Constraints
1 <= number of nodes <= 100000

Input Format
First and only argument is an integer array denoting the preorder traversal of binary tree.

Output Format
Return a string "YES" if true else "NO".

Input 1: A : [4, 10, 5, 8]
Input 2: A : [1, 5, 6, 4]

Output 1: "YES"
Output 2: "NO"

Explanation 1:
 The possible BST is:
            4
             \
             10
             /
             5
              \
              8
Explanation 2:
 There is no possible BST which have the above preorder traversal.
 */
public class CheckBSTWithOneChild {

	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(4, 10, 5, 8);
		System.out.println(isBST(list));

	}

	public static String isBST(List<Integer> A) {
		int L = Integer.MIN_VALUE;
		int R = Integer.MAX_VALUE;
		int root = A.get(0);

		for (int i = 1; i < A.size(); i++) {
			if (A.get(i) > root)
				L = root;
			else
				R = root;

			//if current element is not lies between the L and R range
			if (A.get(i) < L || A.get(i) > R)
				return "NO";
			root = A.get(i);
		}
		return "YES";
	}
	
	public String solve(int[] A) {
        int n = A.length;

        if (n <= 2) {
            return "YES";
        }
        int mn = Math.min(A[n - 1], A[n - 2]);
        int mx = Math.max(A[n - 1], A[n - 2]);

        for (int i = n - 3; i >= 0; i--) {
            // Each node must be either smaller than the min node or larger than the max node
            if (A[i] > mn && A[i] < mx) {
                return "NO";
            }
            mn = Math.min(mn, A[i]);
            mx = Math.max(mx, A[i]);
        }
        return "YES";
    }
}
