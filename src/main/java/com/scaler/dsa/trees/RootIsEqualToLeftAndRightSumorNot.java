package com.scaler.dsa.trees;

/*
Problem Description
Given a binary tree. Check whether the given tree is a Sum-binary Tree or not.
Sum-binary Tree is a Binary Tree where the value of a every node is equal to sum of the nodes present in 
its left subtree and right subtree.

An empty tree is Sum-binary Tree and sum of an empty tree can be considered as 0. 
A leaf node is also considered as SumTree.
Return 1 if it sum-binary tree else return 0.

Problem Constraints
1 <= length of the array <= 100000
0 <= node values <= 50

Input Format
The only argument given is the root node of tree A.

Output Format
Return 1 if it is sum-binary tree else return 0.

Input 1:
       26
     /    \
    10     3
   /  \     \
  4   6      3
Input 2:

       26
     /    \
    10     3
   /  \     \
  4   6      4

Output 1: 1
Output 2: 0

Explanation 1:
 All leaf nodes are considered as SumTree. 
 Value of Node 10 = 4 + 6.
 Value of Node 3 = 0 + 3 
 Value of Node 26 = 20 + 6 

Explanation 2:
 Sum of left subtree and right subtree is 27 which is not equal to the value of root node which is 26.
 */

public class RootIsEqualToLeftAndRightSumorNot {

	static class Pair {
		int sum;
		boolean isSum;

		Pair(int sum, boolean isSum) {
			this.sum = sum;
			this.isSum = isSum;
		}
	}

	static TreeNode root;
	public static void main(String[] args) {
		root = new TreeNode(26);
		root.left = new TreeNode(10);
		root.right = new TreeNode(3);
		root.right.right = new TreeNode(3);

		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(6);

		System.out.println(replaceNodes(root));

		System.out.println(solve(root));
	}

	// Time Complexity-O(n)
	// Space complexity O(n)
	public static int solve(TreeNode A) {
		Pair p = isSum(A);
		return p.isSum ? 1 : 0;
	}

	public static Pair isSum(TreeNode A) {
		if (A == null)
			return new Pair(0, true);
		if (A.left == null && A.right == null)
			return new Pair(A.val, true);
		Pair lst = isSum(A.left);
		Pair rst = isSum(A.right);
		if (lst.isSum && rst.isSum && (lst.sum + rst.sum == A.val))
			return new Pair(lst.sum + rst.sum + A.val, true);
		return new Pair(0, false);
	}

	// Time Complexity O(n^2)
	// Space Complexity O(n)
	private static int replaceNodes(TreeNode root) {
		if (root == null)
			return 1;
		if (root.left == null && root.right == null)
			return 1;

		int left = sumTree(root.left);
		int right = sumTree(root.right);

		if (left + right == root.val && replaceNodes(root.left) == 1 && replaceNodes(root.right) == 1)
			return 1;

		return 0;

	}

	private static int sumTree(TreeNode root) {
		if (root == null)
			return 0;
		int sum = root.val + sumTree(root.left) + sumTree(root.right);

		return sum;
	}
}
