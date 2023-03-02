package com.scaler.dsa.trees;

/*
We can search an node in tree using four ways:
1- Inorder -Left Root Right
2- Preorder- Root Left Right
3- post order- Left Right Root.
4-Level orde traversal-Level wise
 */
public class SearchKInBinaryTree {
	static TreeNode root;

	public static void main(String[] args) {
		root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);

		System.out.println(search(root,5));
	}


	private static boolean search(TreeNode root, int T) {
		if(root==null)
			return false;
		if(root.val==T || search(root.left, T)|| search(root.right, T))
			return true;
		
		return false;
	}
}