package com.scaler.dsa.trees;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class DeserializeBinaryTree {

	public static void main(String[] args) {

		TreeNode root1 = orderTraversal(Arrays.asList(1, 2, 3, 4, 5, -1, -1, -1, -1, -1, -1));
		printAllLevelsEff(root1);
	}

	public static TreeNode orderTraversal(List<Integer> A) {
		Queue<TreeNode> q = new LinkedList<>();

		TreeNode root = new TreeNode(A.get(0));
		q.add(root);

		int i = 1;
		while (!q.isEmpty()) {
			TreeNode f = q.poll();

			if (A.get(i) != -1) {
				f.left = new TreeNode(A.get(i));
				q.add(f.left);
			}
			i++;
			if (A.get(i) != -1) {
				f.right = new TreeNode(A.get(i));
				q.add(f.right);
			}
			i++;
		}
		return root;
	}

	private static void printAllLevelsEff(TreeNode root) {
		Queue<TreeNode> q = new LinkedList<>();

		q.add(root);
		q.add(null);

		while (!q.isEmpty()) {
			TreeNode f = q.poll();
			if (f == null) {
				System.out.println();
			} else {
				System.out.print(f.val + " ");

				if (f.left != null)
					q.add(f.left);
				if (f.right != null)
					q.add(f.right);
				q.add(null);
			}
		}
	}
}
