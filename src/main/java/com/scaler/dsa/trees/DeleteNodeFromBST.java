package com.scaler.dsa.trees;

/*
Given a Binary search tree, the task is to delete a given node.There could be of three types of nodes:
1: No child node
2: One child node
3: Two children node.
 */
public class DeleteNodeFromBST {

	static TreeNode root;

	public static void main(String[] args) {
		root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);

		TreeNode res = deleteNode(root, 2);
		System.out.println(res);

	}

	static TreeNode deleteNode(TreeNode root, int key) {
		// searching
		if (root == null) {
			return null;
		}
		// key is less than root
		if (key < root.val) {
			root.left = deleteNode(root.left, key);
			return root;
		}
		// key is greater than root
		else if (key > root.val) {
			root.right = deleteNode(root.right, key);
			return root;
		}

		// key == root (this node should be deleted)
		// no child
		// 1 child
		// 2 children
		else if (root.left == null && root.right == null) {
			return null;
		} else if (root.left != null && root.right == null) {
			return root.left;
		} else if (root.left == null && root.right != null) {
			return root.right;
		} else {
			// 2 children
			TreeNode temp = root.left;
			// find max
			while (temp.right != null) {
				temp = temp.right;
			}
			// replacing root data with largest in LST
			root.val = temp.val;
			// delete 14 from left subtree
			root.left = deleteNode(root.left, temp.val);
			return root;
		}
	}
}
