package com.scaler.dsa.trees;
/*
LCA--Lowest common Ancestor
 */
public class LCABST {

	static TreeNode root;

	public static void main(String[] args) {
		root = new TreeNode(50);
		root.left = new TreeNode(30);
		root.right = new TreeNode(70);
		root.left.left = new TreeNode(20);
		root.left.right = new TreeNode(40);

		root.right.left = new TreeNode(60);
		root.right.right = new TreeNode(80);

		System.out.println(lcaOfBST(root, 20, 80));
	}

	private static int lcaOfBST(TreeNode root, int a, int b) {
		if (a > root.val && b > root.val)
			return lcaOfBST(root.right, a, b);
		else if (a < root.val && b < root.val)
			return lcaOfBST(root.left, a, b);
		else
			return root.val;
	}

}
