package com.scaler.dsa.trees;

public class PrintKthLevelInTree {
	static TreeNode root;
	public static void main(String[] args) {
		root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		
		printKthLevel(root,2);


	}
	private static void printKthLevel(TreeNode root, int k) {
		if(root==null)
			return;
		if(k==0) {
			System.out.print(root.val+" ");
			return;
		}
		printKthLevel(root.left, k-1);
		printKthLevel(root.right, k-1);
		
		
	}

}
