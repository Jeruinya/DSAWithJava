package com.scaler.dsa.trees;
/*
Given a binary tree, replace every node in the tree with sum of all its descendants
 */
public class ReplaceEveryNodeWithSumOfDescendant {
	static TreeNode root;

	public static void main(String[] args) {
		root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.right.right = new TreeNode(6);
		root.right.right.left = new TreeNode(7);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);

		root.left.left.left = new TreeNode(8);
		root.left.left.right = new TreeNode(9);
		printInorder(root);
		System.out.println();
		int res=replaceNodes(root);
		printInorder(root);

	}

	private static int replaceNodes(TreeNode root) {
		if(root==null)
			return 0;
		else if(root.left==null && root.right==null)
			return root.val;
		else {
			int left=replaceNodes(root.left);
			int right=replaceNodes(root.right);
			int temp=root.val;
			root.val=left+right;
			return left+right+temp;
		}
	}

	public static void printInorder(TreeNode node) {
		if (node == null)
			return;
		System.out.print(node.val + " ");
		printInorder(node.left);
		printInorder(node.right);
	}
}
