package com.scaler.dsa.trees;

/*
Problem Description
Given two binary trees, check if they are equal or not.
Two binary trees are considered equal if they are structurally identical and the nodes have the same value.
Problem Constraints
1 <= number of nodes <= 105
Input Format
The first argument is a root node of the first tree, A.
The second argument is a root node of the second tree, B.
Output Format
Return 0 / 1 ( 0 for false, 1 for true ) for this problem.

Input 1:
   1       1
  / \     / \
 2   3   2   3
Input 2:
   1       1
  / \     / \
 2   3   3   3

Output 1: 1
Output 2: 0

Explanation 1:
 Both trees are structurally identical and the nodes have the same value.
Explanation 2:
 Values of the left child of the root node of the trees are different.
 */
public class IsIdenticalTwoBT {

	static TreeNode A;
	static TreeNode B;
	
	public static void main(String[] args) {

		 A = new TreeNode(1);
		 A.left = new TreeNode(2);
		 A.right = new TreeNode(3);

		 B = new TreeNode(1);
		 B.left = new TreeNode(2);
		 B.right = new TreeNode(3);
		
		 System.out.println(isSameTree(A,B));

	}

	public static int isSameTree(TreeNode A, TreeNode B) {
		if (A == null && B == null)
			return 1;
		if (A == null && B != null)
			return 0;
		if (A != null && B == null)
			return 0;
		if (A.val == B.val && isSameTree(A.left, B.left) == 1 && isSameTree(A.right, B.right) == 1)
			return 1;

		return 0;
	}
}
