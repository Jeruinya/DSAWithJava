package com.scaler.dsa.trees;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class DeserializeBinaryTree {

	public static void main(String[] args) {
		//TreeNode root = buildTreeUsingLevelOrderTrav();
		//printAllLevelsEff(root);
		
	  TreeNode root1 = orderTraversal(Arrays.asList(1, 2, 3, 4, 5, -1, -1, -1, -1, -1, -1));
	  printAllLevelsEff(root1);
		
	}

	// 1 2 3 4 5 -1 6 -1 -1 7 -1 -1 -1 -1 -1
	private static TreeNode buildTreeUsingLevelOrderTrav() {

		Queue<TreeNode> q = new LinkedList<>();
		Scanner s = new Scanner(System.in);
		int data = s.nextInt();
		TreeNode root = new TreeNode(data);
		q.add(root);

		while (!q.isEmpty()) {
			TreeNode f = q.poll();
			int c1 = s.nextInt();
			int c2 = s.nextInt();
			if (c1 != -1) {
				f.left = new TreeNode(c1);
				q.add(f.left);
			}
			if (c2 != -1) {
				f.right = new TreeNode(c2);
				q.add(f.right);
			}
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

}
