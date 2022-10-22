package com.scaler.dsa.trees;

/*
Largest distance between any two nodes of the tree.

The diameter of a tree is the number of nodes on the longest path between two leaves in the tree. 
The diagram below shows two trees each with diameter nine, the leaves that form the ends of the longest 
path are colored (note that there may be more than one path in the tree of the same diameter).
 */
public class DiameterOfTree {

	static TreeNode root;

	public static void main(String[] args) {
		root = new TreeNode(50);
		root.left = new TreeNode(30);
		root.right = new TreeNode(70);
		root.left.left = new TreeNode(20);
		root.left.right = new TreeNode(40);

		root.right.left = new TreeNode(60);
		root.right.right = new TreeNode(80);

		System.out.println(diameter(root));
		System.out.println(diameter(root));

	}

	private static int diameter(TreeNode root) {
		if (root == null)
			return 0;
		int lh = height(root.left);
		int rh = height(root.right);
		int d1 = lh + rh;
		int d2 = diameter(root.left);
		int d3 = diameter(root.right);

		int res = Math.max(d2, d3);

		return Math.max(res, d1);
	}

	private static int height(TreeNode root) {
		if (root == null)
			return 0;

		return 1 + Math.max(height(root.left), height(root.right));
	}
}
