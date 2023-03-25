package com.scaler.dsa.trees;

import java.util.HashSet;

/*
Problem Description
Given a binary search tree A, where each node contains a positive integer, and an integer B, you have to find 
whether or not there exist two different nodes X and Y such that X.value + Y.value = B.
Return 1 to denote that two such nodes exist. Return 0, otherwise.

Problem Constraints
1 <= size of tree <= 100000
1 <= B <= 109

Input Format
First argument is the head of the tree A.
Second argument is the integer B.

Output Format
Return 1 if such a pair can be found, 0 otherwise.

Input 1:
         10
         / \
        9   20

B = 19
Input 2:
 
          10
         / \
        9   20

B = 40

Output 1: 1
Output 2: 0

Explanation 1:
 10 + 9 = 19. Hence 1 is returned.
Explanation 2:
 No such pair exists.
 */
public class TwoSumBST {
	static TreeNode root;
	static HashSet<Integer> s = new HashSet<Integer>();

	public static void main(String[] args) {
		root = new TreeNode(10);
		root.left = new TreeNode(9);
		root.right = new TreeNode(20);

		System.out.println(t2Sum(root, 19));

	}

	public static int t2Sum(TreeNode A, int B) {
		if (A == null)
			return 0;
		int left = t2Sum(A.left, B);
		int right = t2Sum(A.right, B);
		if (s.contains(B - A.val))
			return 1;
		s.add(A.val);
		return left | right;
	}

}
