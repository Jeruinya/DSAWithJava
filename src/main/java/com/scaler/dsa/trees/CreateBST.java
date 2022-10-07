package com.scaler.dsa.trees;

/*
Balanced BT/BST-->A BT/BST is height balanced tree if height of LST and height of RST at all node differ by at max one.
Math.abs(H of LST-Height of RST)<=1

Height of Balanced tree is logN.

 */
public class CreateBST {

	public static void main(String[] args) {
		int A[] = { 5, 3, 8, 7, 2, 6, 0, 9, 9, 5 };

		TreeNode root = createBST(A);
		printInorder(root);

	}

	private static TreeNode createBST(int[] A) {

		TreeNode root = null;
		for (int a : A)
			root = insert(root, a);

		return root;
	}

	private static TreeNode insert(TreeNode root, int data) {
		if (root == null) {
			root = new TreeNode(data);
			return root;
		}
		if (root.val < data)
			root.right = insert(root.right, data);
		else
			root.left = insert(root.left, data);
		return root;
	}

	public static void printInorder(TreeNode node) {

		if (node == null)
			return;

		printInorder(node.left);
		System.out.print(node.val+" ");
		printInorder(node.right);
	}
}
