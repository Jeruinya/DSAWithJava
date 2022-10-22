package com.scaler.dsa.trees;

public class ConvertBinaryTreeToDLL {

	static TreeNode root;
	static TreeNode head;
	static TreeNode prev = null;

	public static void main(String[] args) {
		root = new TreeNode(10);
		root.left = new TreeNode(12);
		root.right = new TreeNode(15);
		root.left.left = new TreeNode(25);
		root.left.right = new TreeNode(30);
		root.right.left = new TreeNode(36);

		// convert to DLL
		binaryTree2DoubleLinkedList(root);

		// Print the converted List
		printList(head);

	}

	public static void binaryTree2DoubleLinkedList(TreeNode root) {
		if (root == null)
			return;

		// Recursively convert left subtree
		binaryTree2DoubleLinkedList(root.left);

		// Now convert this node
		if (prev == null)
			head = root;
		else {
			root.left = prev;
			prev.right = root;
		}
		prev = root;

		// Finally convert right subtree
		binaryTree2DoubleLinkedList(root.right);
	}

	static void printList(TreeNode node) {
		while (node != null) {
			System.out.print(node.val + " ");
			node = node.right;
		}
	}
}
