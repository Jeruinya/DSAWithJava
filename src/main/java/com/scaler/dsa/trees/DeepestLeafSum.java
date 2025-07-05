package com.scaler.dsa.trees;
/*
Given the root of the binary tree , return the sum of the values of its deepest leaves.

Approach:
1- find the max depth
2-Iterate and sum all the values which are lying on max depth line
 */
public class DeepestLeafSum {
	static TreeNode root;
	static int sum = 0;

	public static void main(String[] args) {
		root = new TreeNode(50);
		root.left = new TreeNode(30);
		root.right = new TreeNode(70);
		root.left.left = new TreeNode(20);
		root.left.right = new TreeNode(40);

		root.right.left = new TreeNode(60);
		root.right.right = new TreeNode(80);

		System.out.println(deepestLeafSum(root));
	}

	private static int deepestLeafSum(TreeNode root) {
		int maxDepth = maxDepth(root);
		findSum(root, 1, maxDepth);
		return sum;
	}

	private static int maxDepth(TreeNode root) {
		if (root == null)
			return 0;
		return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
	}

	private static void findSum(TreeNode root, int curr, int maxDepth) {
		if (root != null) {
			if (curr == maxDepth) {
				sum += root.val;
			}
			findSum(root.left, curr + 1, maxDepth);
			findSum(root.right, curr + 1, maxDepth);
		}
	}
}
