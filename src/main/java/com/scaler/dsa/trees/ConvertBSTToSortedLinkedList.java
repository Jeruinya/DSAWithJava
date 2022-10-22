package com.scaler.dsa.trees;
/*
Given a binary search tree and the task is to covert binary search tree to a sorted linked list.
Change right of every node
change left ==null for every node

 */

class Pair {
	TreeNode head;
	TreeNode tail;

	Pair(TreeNode head, TreeNode tail) {
		this.head = head;
		this.tail = tail;
	}
}

public class ConvertBSTToSortedLinkedList {

	static TreeNode root;

	public static void main(String[] args) {
		root = new TreeNode(15);
		root.left = new TreeNode(12);
		root.right = new TreeNode(20);
		root.left.left = new TreeNode(10);
		root.left.right = new TreeNode(14);
		root.left.left.left = new TreeNode(8);
		root.right.right = new TreeNode(27);
		root.right.left = new TreeNode(16);
		Pair res = convertTreeToLL(root);
		print(res.head);
	}

	private static Pair convertTreeToLL(TreeNode root) {
		if (root.left == null && root.right == null)
			return new Pair(root, root);
		else if (root.left != null && root.right == null) {
			Pair leftll = convertTreeToLL(root.left);
			leftll.tail.right = root;
			root.left = null;
			return new Pair(leftll.head, root);
		}

		else if (root.left == null && root.right != null) {
			Pair rightll = convertTreeToLL(root.right);
			root.right = rightll.head;
			return new Pair(root, rightll.tail);
		} else {
			Pair leftll = convertTreeToLL(root.left);
			Pair rightll = convertTreeToLL(root.right);
			leftll.tail.right = root;
			root.right = rightll.head;
			root.left = null;
			return new Pair(leftll.head, rightll.tail);
		}
	}

	private static void print(TreeNode res) {
		while (res != null) {
			System.out.print(res.val + " ");
			res = res.right;
		}
	}
}
