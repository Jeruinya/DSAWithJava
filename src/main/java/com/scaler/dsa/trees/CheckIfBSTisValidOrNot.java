package com.scaler.dsa.trees;

public class CheckIfBSTisValidOrNot {
	static TreeNode root;

	public static void main(String[] args) {
		root = new TreeNode(50);
		root.left = new TreeNode(30);
		root.right = new TreeNode(70);
		root.left.left = new TreeNode(20);
		root.left.right = new TreeNode(40);

		root.right.left = new TreeNode(60);
		root.right.right = new TreeNode(80);
		System.out.println(isValidBST(root));

	}

	public static int isValidBST(TreeNode A) {

		boolean res = isBST(A, Long.MIN_VALUE, Long.MAX_VALUE);

		return res == true ? 1 : 0;
	}

	public static boolean isBST(TreeNode root, long minV, long maxV) {
		if (root == null)
			return true;
		if (root.val > minV && root.val < maxV && isBST(root.left, minV, root.val) && isBST(root.right, root.val, maxV))
			return true;
		return false;
	}

}
