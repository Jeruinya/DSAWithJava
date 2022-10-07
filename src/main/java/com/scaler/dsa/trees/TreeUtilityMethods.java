package com.scaler.dsa.trees;

public class TreeUtilityMethods {
	static TreeNode root;

	public static void main(String[] args) {
		root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		
		System.out.println(heightHelper(root));
		System.out.println(countNodes(root));
		System.out.println(sumNodes(root));
	}

	private static int heightHelper(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int h1 = heightHelper(root.left);
		int h2 = heightHelper(root.right);
		return Math.max(h1, h2) + 1;
		// return Math.max(heightHelper(root.left),heightHelper(root.right)) + 1;
	}

	public static int countNodes(TreeNode root) {
		if (root == null) {
			return 0;
		}
		return 1 + countNodes(root.left) + countNodes(root.right);
	}

	static int sumNodes(TreeNode root) {
		if (root == null)
			return 0;
		return root.val + sumNodes(root.left) + sumNodes(root.right);
	}

}
