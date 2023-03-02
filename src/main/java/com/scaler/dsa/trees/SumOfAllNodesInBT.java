package com.scaler.dsa.trees;
/*
Given a binary tree find the sum of all the nodes present
 */
public class SumOfAllNodesInBT {
	static TreeNode root;

	public static void main(String[] args) {
		root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);

		System.out.println(sumOfNodes(root));
	}

	private static int sumOfNodes(TreeNode root) {
		if (root == null)
			return 0;
		return root.val + sumOfNodes(root.left) + sumOfNodes(root.right);
	}

}
