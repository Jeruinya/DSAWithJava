package com.scaler.dsa.trees;

class BinaryTreeTraversal {
	static TreeNode root;

	public static void main(String[] args) {
		root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);

		System.out.println("Preorder traversal of binary tree is ");
		printPreorder(root);

		System.out.println("\nInorder traversal of binary tree is ");
		printInorder(root);

		System.out.println("\nPostorder traversal of binary tree is ");
		printPostorder(root);
		System.out.println(root);

		printSumOfNodes();
	}

	static void printPostorder(TreeNode node) {
		if (node == null)
			return;

		printPostorder(node.left);
		printPostorder(node.right);
		System.out.print(node.val + " ");
	}

	static void printInorder(TreeNode node) {
		if (node == null)
			return;

		printInorder(node.left);
		System.out.print(node.val + " ");
		printInorder(node.right);
	}

	static void printPreorder(TreeNode node) {
		if (node == null)
			return;

		System.out.print(node.val + " ");
		printPreorder(node.left);
		printPreorder(node.right);
	}

	static void printSumOfNodes() {
		int sum = sumOfNodes(root);
		System.out.println("Sum of Nodes is:" + sum);
	}

	private static int sumOfNodes(TreeNode root) {
		if (root == null)
			return 0;

		return root.val + sumOfNodes(root.left) + sumOfNodes(root.right);
	}
}