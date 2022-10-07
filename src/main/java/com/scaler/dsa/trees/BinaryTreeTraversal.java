package com.scaler.dsa.trees;

class BinaryTreeTraversal {
	TreeNode root;

	BinaryTreeTraversal() {
		root = null;
	}

	void printPostorder(TreeNode node) {
		if (node == null)
			return;

		printPostorder(node.left);
		printPostorder(node.right);
		System.out.print(node.val + " ");
	}

	void printInorder(TreeNode node) {
		if (node == null)
			return;

		printInorder(node.left);
		System.out.print(node.val + " ");
		printInorder(node.right);
	}

	void printPreorder(TreeNode node) {
		if (node == null)
			return;

		System.out.print(node.val + " ");
		printPreorder(node.left);
		printPreorder(node.right);
	}

	void printPostorder() {
		printPostorder(root);
	}

	void printInorder() {
		printInorder(root);
	}

	void printPreorder() {
		printPreorder(root);
	}


	void printSumOfNodes() {
		int sum = sumOfNodes(root);
		System.out.println("Sum of Nodes is:" + sum);
	}

	private int sumOfNodes(TreeNode root) {
		if (root == null)
			return 0;

		return root.val + sumOfNodes(root.left) + sumOfNodes(root.right);
	}

	// Driver method
	public static void main(String[] args) {
		BinaryTreeTraversal tree = new BinaryTreeTraversal();
		tree.root = new TreeNode(1);
		tree.root.left = new TreeNode(2);
		tree.root.right = new TreeNode(3);
		tree.root.left.left = new TreeNode(4);
		tree.root.left.right = new TreeNode(5);

		System.out.println("Preorder traversal of binary tree is ");
		tree.printPreorder();

		System.out.println("\nInorder traversal of binary tree is ");
		tree.printInorder();

		System.out.println("\nPostorder traversal of binary tree is ");
		tree.printPostorder();
		System.out.println();

		tree.printSumOfNodes();
	}
}