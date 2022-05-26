package com.scaler.dsa.trees;

public class SearchKInBinaryTree {
	TreeNode root;

	public static void main(String[] args) {
		SearchKInBinaryTree tree = new SearchKInBinaryTree();
		tree.root = new TreeNode(1);
		tree.root.left = new TreeNode(2);
		tree.root.right = new TreeNode(3);
		tree.root.left.left = new TreeNode(4);
		tree.root.left.right = new TreeNode(5);

		tree.isKpresent();
	}

	private void isKpresent() {
		int k = 5;
		boolean flag = inorder(root, k);
		System.out.println(flag);
	}

	private boolean inorder(TreeNode root, int k) {
		if (root == null)
			return false;
		if (root.key == k)
			return true;
		boolean f1 = inorder(root.left, k);
		if (f1 == true)
			return true;
		boolean f2 = inorder(root.right, k);

		if (f2 == true)
			return true;

		return false;
	}

}