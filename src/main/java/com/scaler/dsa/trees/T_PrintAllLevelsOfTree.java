package com.scaler.dsa.trees;
/*
Given  a tree print all the nodes using level order traversal or BFS(breath first search)
 */
import java.util.LinkedList;
import java.util.Queue;

public class T_PrintAllLevelsOfTree {
	static TreeNode root;

	public static void main(String[] args) {
		root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);

		printAllLevelsNaive(root);
		
		printAllLevelsEff(root);
	}

	private static void printAllLevelsEff(TreeNode root) {
		Queue<TreeNode> q= new LinkedList<>();
		
		q.add(root);
		q.add(null);
		
		while(!q.isEmpty()) {
			TreeNode f= q.poll();
			if(f==null) {
				System.out.println();
			}else {
			System.out.print(f.val+" ");
			
			if(f.left!=null)
				q.add(f.left);
			if(f.right!=null)
				q.add(f.right);
			q.add(null);
			}
		}
	}

	//Time complexity O(N^2) and space-O(Height)
	private static void printAllLevelsNaive(TreeNode root) {
		for(int k=0;k<heightHelper(root);k++) {
			printKthLevel(root, k);
			System.out.println();
		}

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


	private static int heightHelper(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int h1 = heightHelper(root.left);
		int h2 = heightHelper(root.right);
		return Math.max(h1, h2) + 1;
		// return Math.max(heightHelper(root.left),heightHelper(root.right)) + 1;
	}

}
