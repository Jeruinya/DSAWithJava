package com.scaler.dsa.trees;

import java.util.Stack;

public class T_InorderTraversalIterative {

	static TreeNode root;

	public static void main(String[] args) {
		root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);

		inorderTraversalItr(root);

	}

	private static void inorderTraversalItr(TreeNode root) {
		TreeNode temp = root;
		if(root==null)
			return;
		Stack<TreeNode> s = new Stack<>();
		
		while (temp != null || !s.isEmpty()) {
			while (temp != null) {
				s.push(temp);
				temp = temp.left;
			}
			temp=s.pop();
			System.out.print(temp.val+" ");;
			temp = temp.right;

		}
	}

}
