package com.scaler.dsa.trees;

/*
Problem Description
You are given a Binary Tree A with N nodes.
Write a function that returns the size of the largest subtree, which is also a Binary Search Tree (BST).
If the complete Binary Tree is BST, then return the size of the whole tree.
NOTE:
The largest subtree is the subtree with the most number of nodes.

Problem Constraints
1 <= N <= 105
Input Format
First and only argument is an pointer to root of the binary tree A.

Output Format
Return an single integer denoting the size of the largest subtree which is also a BST.

Input 1:
     10
    / \
   5  15
  / \   \ 
 1   8   7
Input 2:
     5
    / \
   3   8
  / \ / \
 1  4 7  9

Output 1: 3
Output 2: 7

Explanation 1:
 Largest BST subtree is
                            5
                           / \
                          1   8
Explanation 2:
 Given binary tree itself is BST.
 */
public class LargestBSTSubtree {
	static int ans = Integer.MIN_VALUE;
	static TreeNode root;

	public static void main(String[] args) {
		root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		System.out.println(solve(root));
	}

	public static int solve(TreeNode A) {
		int k = isValid(A);
		return ans;
	}

	public static int isValid(TreeNode A) {
		if (A == null)
			return 0;
		int a = isValid(A.left);
		int b = isValid(A.right);

		if (A.right != null && A.val > A.right.val)
			return -1;
		if (A.left != null && A.val < A.left.val)
			return -1;

		if (a != -1 && b != -1) {
			ans = Math.max(ans, a + b + 1);
			return a + b + 1;
		}

		return -1;
	}
}
