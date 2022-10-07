package com.scaler.dsa.trees;

public class SearchingDataInBST {

	static TreeNode root;

	public static void main(String[] args) {
		root = new TreeNode(50);
		root.left = new TreeNode(30);
		root.right = new TreeNode(70);
		root.left.left = new TreeNode(20);
		root.left.right = new TreeNode(40);

		root.right.left = new TreeNode(60);
		root.right.right = new TreeNode(80);
		System.out.println(searchRecursive(root, 40));
		
		System.out.println(searchItrative(root, 40));

	}

	private static boolean searchItrative(TreeNode root, int k) {
		
		while(root!=null) {
			if(root.val==k)
				return true;
			else if(k<=root.val)
				root=root.left;
			else
				root=root.right;
		}
		return false;
	}

	private static boolean searchRecursive(TreeNode root, int k) {
		if (root == null)
			return false;
		if (root.val == k)
			return true;
		else if (k <= root.val)
			return searchRecursive(root.left, k);
		else
			return searchRecursive(root.right, k);
	}
}
